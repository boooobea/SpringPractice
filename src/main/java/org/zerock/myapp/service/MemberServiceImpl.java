package org.zerock.myapp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.MemberMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor
@Service
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Override
	public int memberJoin(MemberDTO dto) throws ServiceException {
		try {
			return this.memberMapper.insertMember(dto);			
		}catch(Exception e) { throw new ServiceException(e); }
	}//memberJoin

	@Override
	public int idCheck(String memberId) throws ServiceException {
		try {			
			return this.memberMapper.idCheck(memberId);
		}catch(Exception e) {throw new ServiceException(e);}
	}//idCheck

	//----------------------------------------------//
	public void mailSend() {
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111; //랜덤난수생성
	}
}//end class
