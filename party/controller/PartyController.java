package www.dream.party.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.dream.party.model.PartyVO;
import www.dream.party.service.PartyService;

@RestController //Container에 담기도록 지정
@RequestMapping("/party")

public class PartyController {
	@Autowired
	private PartyService partyservice;
	
	@GetMapping("/listAll") 
	public ResponseEntity<?> listAll() {
		List<PartyVO> list = partyservice.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	/** @GetMapping("/{dd}") // 이런 식으로 가능.
	public ResponseEntity<?> findBydd(@PathVariable String dd) { // Model = 정보 (인터페이스 / 스프링이 만들어 우리에게 준것)
		BoardVO boards = boardservice.findBydd(dd);
		return new ResponseEntity<>(boards, HttpStatus.OK);
	} */
}
