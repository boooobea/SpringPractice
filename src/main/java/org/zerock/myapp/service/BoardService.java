package org.zerock.myapp.service;

import java.util.List;

import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.exception.ServiceException;

public interface BoardService {

	
	//-------- Board 
	
	public abstract int createBoard(BoardDTO dto) throws ServiceException;
		
	public abstract BoardVO getBoard(Integer bno) throws ServiceException;
		
	public abstract List<BoardVO> getAllBoard() throws ServiceException;

	public abstract int modifyBoard(BoardDTO dto) throws ServiceException;
		
	public abstract int removeBoard(Integer bno) throws ServiceException;

	//-------- paging 
//	
//	public abstract List<BoardVO> PageList(Criteria cri) throws ServiceException;
//	
//	public abstract int PageCount(Criteria cri) throws ServiceException;
}//end 
