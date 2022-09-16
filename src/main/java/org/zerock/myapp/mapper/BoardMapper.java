package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.DAOException;

//DAO 역할
public interface BoardMapper {

	//--------------- Board 
	
	public abstract int insertBoard(BoardDTO dto) throws DAOException;
	
	@Select("SELECT * FROM tbl_board WHERE bno=#{bno}")
	public abstract BoardVO selectBoard(@Param("bno")Integer bno) throws DAOException;
	
	@Select("SELECT /*+index_desc(tbl_board) */ * FROM tbl_board")
	public abstract List<BoardVO> selectAllBoard() throws DAOException;
	
	public abstract int updateBoard(BoardDTO dto) throws DAOException;
	
	@Delete("DELETE FROM tbl_board WHERE bno=#{bno}")
	public abstract int deleteBoard(@Param("bno")Integer bno) throws DAOException;
	
	
	
	//------------- paging
	
	public abstract List<BoardVO> listPage(Criteria cri) throws DAOException;

	public abstract int boardCount(Criteria cri) throws DAOException;
	
//	public abstract List<BoardVO> selectWithPaging(Criteria cri) throws DAOException;
	
	//------------- reple
	
//	@Select("SELECT bno, title")
//	public abstract BoardVO getBoardBno(int bno);
}//end class
