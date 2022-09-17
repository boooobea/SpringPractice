package org.zerock.myapp.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.ServiceException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService memberService;

	@Test
	@DisplayName("memberJoin")
	void memberJoinTest() throws ServiceException {
		log.info("memberJoin test");
	
		MemberDTO dto = new MemberDTO();
		dto.setMemberEmail("member2");
		dto.setMemberId("memder22");
		dto.setMemberMemo("멤버가입중");
		dto.setMemberName("member2");
		dto.setMemberPw("member2");
		int result = this.memberService.memberJoin(dto);
		log.info("\t+ result : {}", result);
	}//memberJoin
	
	@Test
	@DisplayName("idCheck")
	void idCheckTest() throws ServiceException {
		log.info("IdCheck test");

		String memberId = "id3";
		int result = this.memberService.idCheck(memberId);
		log.info("result : {}", result);
	}//idCheck
}//end class
