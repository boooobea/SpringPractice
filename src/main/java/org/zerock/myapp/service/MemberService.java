package org.zerock.myapp.service;

import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.ServiceException;

public interface MemberService {

	public abstract int memberJoin(MemberDTO dto) throws ServiceException;
	
	public abstract int idCheck(String memberId) throws ServiceException;
}// end 
