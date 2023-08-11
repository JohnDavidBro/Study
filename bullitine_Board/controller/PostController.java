package www.dream.bullitine_Board.controller;
/**
 * RestController는 Client 요청에 대한 분배가능(짬때린다)
 * Service로 처리 위임하여 그 결과물을 Client 에 반환. (시켜먹는다)
 * 이 곳에 길게 업무적 처리가 들어와 있으면, 실수 한 것임.
 */
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.bullitine_Board.model.PostVO;
import www.dream.bullitine_Board.model.ReplyVO;
import www.dream.bullitine_Board.service.PostService;
import www.dream.framework.model.nlp.pos.service.NounExtractor;

@RestController //Container에 담기도록 지정
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	// /post/listAll/{boardId}
	@GetMapping("/listAll/{boardId}")
	public ResponseEntity<List<PostVO>> listAllPost(@PathVariable String boardId) {
		List<PostVO> listResult = postService.listAllPost(boardId);
		return new ResponseEntity<>(listResult, HttpStatus.OK);
	}
	/** 원글 상세, 첨부파일(아직안됨), 댓글, 대댓 목록이 내부 변수에 채워짐. */
	// /post/getPost/p001
	@GetMapping("/getPost/{id}")
	public ResponseEntity<PostVO> findById(@PathVariable String id) {
		PostVO post = postService.findById(id);
		if (post == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
	}
	
	// /post/extractorTag?docs=안녕하세요&docs=데이터분석
	// 유일한 단어 집합
	/** Komoran 한글 분석 */
	@GetMapping("/extractorTag")
	public ResponseEntity<Set<String>> extractorTag(String[] docs) {
		Set<String> ret = new HashSet<>();
		for (String doc : docs) {
			ret.addAll(NounExtractor.extractorNoun(doc));
		}	
		return new ResponseEntity<>(ret, HttpStatus.OK);
	}
	
	/* affected row counts (영향받은 행 수) */
	// /post/createPost
	/** 게시판에 원글 달기  */
	@PostMapping("/createPost")
	public ResponseEntity<Integer> createPost(PostVO post) {
		return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
	}

	// /post/createReply
	/** 원글에 댓글 달기, parents의 hid의 연결된 hid 만들기 */
	@PostMapping("/createReply")
	public ResponseEntity<Integer> createReply(ReplyVO parent, ReplyVO reply) {
		return new ResponseEntity<>(postService.createReply(parent, reply), HttpStatus.OK);
	}
	
	// /post/updatePost
	/** 원글 업데이트하기 */
	@PostMapping("/updatePost")
	public ResponseEntity<Integer> updatePost(PostVO post) {
		return new ResponseEntity<>(postService.updatePost(post), HttpStatus.OK);
		}
	// /post/updateReply
	/** 댓글 업데이트 하기 */
	@PostMapping("/updateReply")
	public ResponseEntity<Integer> updateReply(PostVO reply) {
		return new ResponseEntity<>(postService.updateReply(reply), HttpStatus.OK);
		}
	// /post/{id} like 'p001'
	/** hid like 검색으로 지웁니다. */
	@DeleteMapping("/deletePost/{id}")
	public ResponseEntity<Integer> deleteReply(@PathVariable String id) {
		return new ResponseEntity<>(postService.deleteReply(id), HttpStatus.OK);
		}
}
