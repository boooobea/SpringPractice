package org.zerock.myapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.exception.DAOException;

public interface BoardMapper {

	//--------------- Board 
	//게시글 등록
	public abstract int insertBoard(BoardDTO dto) throws DAOException;
	
	//게시글 조회
	@Select("SELECT * FROM test_board WHERE bno=#{bno}")
	public abstract BoardVO selectBoard(@Param("bno")Integer bno) throws DAOException;
	
	//게시글 전체조회
	@Select("SELECT /*+ index_desc(test_board) */* FROM test_board")
	public abstract List<BoardVO> selectAllBoard() throws DAOException;
	
	//게시글 수정
	public abstract int updateBoard(BoardDTO dto) throws DAOException;
	
	//게시글 삭제
	@Delete("DELETE FROM test_board WHERE bno=#{bno}")
	public abstract int deleteBoard(@Param("bno")Integer bno) throws DAOException;
	
	
	
	//------------- paging
	
//	public abstract List<BoardVO> listPage(Criteria cri) throws DAOException;
//
//	public abstract int boardCount(Criteria cri) throws DAOException;
	
//	public abstract List<BoardVO> selectWithPaging(Criteria cri) throws DAOException;
	
	//------------- reple
	
//	@Select("SELECT bno, title")
//	public abstract BoardVO getBoardBno(int bno);
}//end class
