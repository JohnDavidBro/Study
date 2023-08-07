package www.dream.hi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.dream.hi.model.MemberDTO;
import www.dream.hi.model.MemberVO;
import www.dream.hi.service.SA;

@Controller
@RequestMapping("/test")
public class HiController {
	@Autowired
	private SA sa;
	
	@GetMapping("/hi")
	public String hi() {
		return "hi"; //jsp 파일이름과 같아야한다.
	}
	//http://localhost:8080(서버포트)/test(Class Mapping 값)/echo(밑 Mapping 값)?msg(Valuse값)=echo(스트링값)
	@GetMapping("/echo")
	@ResponseBody
	public String echo(@RequestParam(value="msg")String msg) {
		return msg; //jsp 파일이름과 같아야한다.
	}
	// {} Path variable = value="msg" 같은 뜻
	@GetMapping("/umdl/{talk}")
	public String umdl(@PathVariable String talk, Model objTojsp) { // Model = 정보 (인터페이스 / 스프링이 만들어 우리에게 준것)
		objTojsp.addAttribute("talk", talk + "Sir"); //원하는 값, 줄 값을 정한다.
		return "umdl"; //jsp 파일이름과 같아야한다.
	}
	// /test/ho?msg=sdada&age=888
	@GetMapping("/ho")
	public String msg(@PathVariable String msg, int age, Model objTojsp) { // Model = 정보 (인터페이스 / 스프링이 만들어 우리에게 준것)
		objTojsp.addAttribute("msg", msg); //원하는 값, 줄 값을 정한다.
		objTojsp.addAttribute("age", age); //원하는 값, 줄 값을 정한다.
		return "ho"; //jsp 파일이름과 같아야한다.
	}
	// /test/hi2?id="sda"&bal="121"&pwd="sdasda"
	@GetMapping("/hi2")
	public String hi(MemberDTO member, Model objTojsp) { // Model = 정보 (인터페이스 / 스프링이 만들어 우리에게 준것)
		objTojsp.addAttribute("member", member); //원하는 값, 줄 값을 정한다.
		return "hi2"; //jsp 파일이름과 같아야한다.
	}
	// /test/hi3?id="sda"&bal="121"&pwd="sdasda"
	@GetMapping("/hi3")
	public String hi2(MemberDTO member, Model objTojsp) { // Model = 정보 (인터페이스 / 스프링이 만들어 우리에게 준것)
		MemberVO serviced = sa.take(member);
		objTojsp.addAttribute("serviced", serviced); //원하는 값, 줄 값을 정한다.
		return "hi3"; //jsp 파일이름과 같아야한다.
	}
	
}
	

