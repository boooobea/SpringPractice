package org.zerock.myapp.mapper;

import org.zerock.myapp.domain.MemberDTO;
import org.zerock.myapp.exception.DAOException;

public interface MemberMapper {

	
	public abstract int insertMember(MemberDTO memberdto) throws DAOException;
	
	public abstract int idCheck(String memberId) throws DAOException;
}//end interface
