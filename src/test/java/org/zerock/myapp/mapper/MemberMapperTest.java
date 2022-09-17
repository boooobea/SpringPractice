package org.zerock.myapp.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.DAOException;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper membermapper;
	
	@Test
	@DisplayName("insertMember")
	void InsertMemberTest() throws DAOException {
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberId("member123");
		dto.setMemberPw("member1");
		dto.setMemberName("member1");
		dto.setMemberEmail("member1");
		dto.setMemberMemo("가입한 멤버1입니다.");
		int result = this.membermapper.insertMember(dto);
		log.info("\t + result : {}", result);
		
	}//insertMember
	
	@Test
	@Order(2)
	@DisplayName("idCheck")
	void idCheckTest() throws DAOException {
		String memberId1 = "id3";
		String memberId2 = "id12134";
		int result1 = this.membermapper.idCheck(memberId1);
		int result2 = this.membermapper.idCheck(memberId2);
		log.info("\t + result : {}, {}", result1, result2);
	}//idCheck
}//end class
