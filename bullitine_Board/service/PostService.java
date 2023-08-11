package www.dream.bullitine_Board.service;
/**
 * @Service : 업무 처리(짬받은거 처리)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.bullitine_Board.mapper.PostMapper;
import www.dream.bullitine_Board.model.PostVO;
import www.dream.bullitine_Board.model.ReplyVO;
import www.dream.framework.model.nlp.pos.service.NounExtractor;
import www.dream.framework.property.PropertyExtractor;

//Container에 담기도록 지정
@Service // 아키텍쳐 표준
public class PostService {
	@Autowired
	private PostMapper postMapper;

	// STS에서 인터페이스는 빈 껍데기. => MyBatis가 XMl을 보고 자동으로 만들어줌.
	// LRCUD 순서로 함수들을 배치하여 빠르게 따라갈(추적성) 수 있도록 합니다.
	/** 게시판에 모든 원글 목록 조회 */
	public List<PostVO> listAllPost(String boardId) { // 모든 POST LIST 를 간략하게 가져온다.
		List<PostVO> listResult = postMapper.listAllPost(boardId);
		return listResult;
	}

	// 그 중에 한개 게시물 상세조회(게시물상세) 하면 그 안에 댓글이 보인다. (댓글은 상세조회가 없으니까.)
	// 게시물 상세. 첨부파일 목록. 댓글 목록, 대댓글 목록.
	/** 원글 상세, 첨부파일 목록, 댓글 목록, 대댓글 목록이 내부 변수에 채워짐 */
	public PostVO findById(String id) {
		// postMapper.findById(id)는 id의 primary key의 특성으로 사전순서가 보장되어있음.
		List<ReplyVO> oneDimList = postMapper.findById(id); //List없을 시, null이 아니라, emptyList가 나온다.
		if (oneDimList.isEmpty()) {
			return null;
		}
		PostVO ret = (PostVO) oneDimList.get(0);
		Map<String, ReplyVO> map = new HashMap<>();
		for (ReplyVO reply : oneDimList) {
			map.put(reply.getId(), reply);

			ReplyVO parent = map.get(reply.extractParentId());
			if (parent != null) {
				parent.appendReply(reply);
			}
		}
		return ret;
	}

	/* affected row counts (영향받은 행 수) */
	/** 게시판에 원글 달기
	 * 신규 tag면 등록하기. 
	 * 모든 tag와 TF 등재 및 tag의 df 수정(그래야 TF, IDF 가 작동함)
	 */
	@Transactional //단위 작업 처리(은행 이체 처리와 같음)
	public int createPost(PostVO post) {
		
		Map<String, Integer> mapTF = buildTF(post);
		
		return postMapper.createPost(post);
	}

	/** 원글에 댓글 달기, parents의 hid의 연결된 hid 만들기 */
	public int createReply(ReplyVO parent, ReplyVO reply) {
		return postMapper.createReply(parent, reply);
	}

	/** 원글 업데이트하기
	 * TF, DF 정보 수정도 고려해야함. 
	 */
	public int updatePost(PostVO post) {
		return postMapper.updatePost(post);
	}

	/** 댓글 업데이트 하기 */
	public int updateReply(ReplyVO reply) {
		return postMapper.updateReply(reply);
	}

	/** hid like 검색으로 지웁니다.
	 * TF, DF 정보 수정도 고려해야함. 
	 */
	public int deleteReply(String id) {
		return postMapper.deleteReply(id);
	}
	
	/**
	 * private 함수위치(createPost/TF)
	 * @param post
	 * @return
	 *  listTag에 담긴 단어에 대한 처리는
	 * 기존 단어와 새로운 단어로 구분.
	 * TF - IDF
	 * 우리집에는 강아지 코코가 있습니다. 코코는 밝은 성격이고 밥도 많이 먹습니다.
	 * TF(텀 프리콘시) 네오 : 2
	 * TF(텀 프리콘시) 우리집 : 1
	 * TF(텀 프리콘시) 강아지 : 1
	 * TF(텀 프리콘시) 성격 : 1
	 * TF(텀 프리콘시) 밥 : 1
	 */
	private Map<String, Integer> buildTF(PostVO post) {
		List<String> docs = PropertyExtractor.extractorProperty(post);
		
		List<String> listNoun = new ArrayList<>();
		
		for (String doc : docs) {
			listNoun.addAll(NounExtractor.extractorNoun(doc));
		}
		List<String> listTag = post.getListTag();
		Map<String, Integer> mapWordCnt = new HashMap<>();
		listTag.forEach(tag -> mapWordCnt.put(tag, 1));
		
		// listNoun 에서 listTag 가 있는 것만 유지 시킬거야.
		listNoun.retainAll(listTag);
		
		for (String noun : listNoun) {
				mapWordCnt.put(noun, mapWordCnt.get(noun) + 1);
		}
		return mapWordCnt;
	}
}