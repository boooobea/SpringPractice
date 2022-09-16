package org.zerock.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.mapper.BoardMapper;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@NoArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	@Override
	public int createBoard(BoardDTO dto) throws ServiceException {
		try{ 
			int result = this.boardMapper.insertBoard(dto);	
			log.info("\t + result : {}", result);
			return result;
		} catch(Exception e) {throw new ServiceException(e);}
	}//createBoard

	@Override
	public BoardVO getBoard(Integer bno) throws ServiceException {
		try{ 
			BoardVO vo = this.boardMapper.selectBoard(bno);
			log.info("\t + vo : {}", vo);
			return vo;
		} catch(Exception e) {throw new ServiceException(e);}
	}//getBoard

	@Override
	public List<BoardVO> getAllBoard() throws ServiceException {
		try {
			List<BoardVO> list = this.boardMapper.selectAllBoard();
			return list;
		} catch( Exception e) { throw new ServiceException(e); }

	}//getAllBoard

	@Override
	public int modifyBoard(BoardDTO dto) throws ServiceException {
		
		try {
			int result = this.boardMapper.updateBoard(dto);
			log.info("\t + result : {}", result);
			return  result;
		} catch (Exception e) { throw new ServiceException(e); }
	}//modifyBoard

	@Override
	public int removeBoard(Integer bno) throws ServiceException {
		try {
			int result = this.boardMapper.deleteBoard(bno); 
			log.info("\t + result : {}", result);
			return result;
		} catch ( Exception e) {throw new ServiceException(e); }
	}//removeBoard

	@Override
	public List<BoardVO> PageList(Criteria cri) throws ServiceException {
		try {
			List<BoardVO> list = this.boardMapper.listPage(cri);
			return list;
		} catch(Exception e) {throw new ServiceException(e); }
	}//PageList

	@Override
	public int PageCount(Criteria cri) throws ServiceException {
		try {
			return this.boardMapper.boardCount(cri);			
		} catch(Exception e) {throw new ServiceException(e);}
	}//removeBoard


}
