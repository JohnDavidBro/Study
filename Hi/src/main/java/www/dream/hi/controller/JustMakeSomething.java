package www.dream.hi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import www.dream.hi.model.MemberVO;

@RestController // {} Path variable = value="msg" 같은 뜻, 컨테이너에 담겨야해요.
@RequestMapping("/rapid")
public class JustMakeSomething {
	
	@Value("${news.imgdir}")
	String myConfig;
	
	//http://localhost:8080/rapid/mapp?mapp
	@GetMapping("/mapp")
	public List<String> echo(@RequestParam(value = "mapp") String msg) { // (value = "mapp") = 요청파라메터
		List<String> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(myConfig + val + msg));
			return ret; // JSON으로 넘어온 데이터
		

	}
	//http://localhost:8080/rapid/all/members?mapp
	@GetMapping("/all/members")
	public List<MemberVO> listAllMembers(@RequestParam(value = "mapp") String msg) { // 요청파라메터
		List<MemberVO> mvo = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->mvo.add(new MemberVO(msg + val, val, "YapYap")));
			return mvo; // JSON으로 넘어온 데이터
		

	}
	 // value 요청할태니, produces 로 만들어줘 (deprecated//MediaType 의 경우, 쓸 수는 있지만 추천은 안해요. 되도록이면 쓰지마세요.)
	// 대안은 있으니, 잘 찾아서 써보세요.
	@GetMapping(value = "/allxmll/members", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<MemberVO> listAllMembersXML(@RequestParam(value = "mappp") String msg) { // 요청파라메터
		List<MemberVO> mvo = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->mvo.add(new MemberVO(msg + val, val, "YapYap")));
			return mvo; // JSON으로 넘어온 데이터
	}
	@GetMapping(value = "/allxml/members", produces = MediaType.APPLICATION_XML_VALUE) // value 요청할태니, produces 로 만들어줘
	public List<MemberVO> listAllMembersXMLa(@RequestParam(value = "mapp") String msg) { // 요청파라메터
		List<MemberVO> mvo = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->mvo.add(new MemberVO(msg + val, val, "YapYap")));
			return mvo; // JSON으로 넘어온 데이터
	}
	
}
