package org.zerock.myapp.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.ControllerException;
import org.zerock.myapp.service.MemberService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Log4j2
@NoArgsConstructor
@Controller
@RequestMapping("/member/")
public class MemberController {

	@Setter(onMethod_ = @Autowired)
	private MemberService memberservice;

	//----------------------------------------------//
	
	@GetMapping("/login")
	public void loginGET() {
		log.info("LoginPage");
	}//loginGET
	
	@GetMapping("/join")
	public void joinGET() {
		log.info("JoinPage");
	}//joinGET

	@PostMapping("/join")
	public String joinPOST(MemberDTO dto) throws ControllerException {
		log.info("JoinPOST.");
		try {
			this.memberservice.memberJoin(dto);
			log.info("\t + Join succese");
			return "redirect:/main";
		}catch(Exception e) {throw new ControllerException(e); }
	}//joinPOST
	
	@PostMapping("/memberIdChk")
	@ResponseBody
	public String memberIdChk(String memberId) throws ControllerException {
		log.info("memberIdChk. ");
		try {
			int result = this.memberservice.idCheck(memberId);
			if(result == 0) {
				return "success";
			} else {
				return "fail";
			}
		}catch(Exception e) { throw new ControllerException(e); }
	}//memberIdChk
	
	@GetMapping("/mailCheck")
	@ResponseBody
	public void mailCheck(String email) {
		log.info("mailCheck. email : {}", email);

		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111; //랜덤난수생성
		
		log.info("\t + 랜덤인증번호 : {}", checkNum);
		
		String setFrom = "childhopp@naver.com";
	}//mailCheck
}//end class 
