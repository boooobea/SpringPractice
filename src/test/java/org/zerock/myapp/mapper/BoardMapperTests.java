package org.zerock.myapp.mapper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
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
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper boardMapper;
	
	
	@Test
	@Order(1)
	@DisplayName("InsertBoard")
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testIntertBoard() throws DAOException {
		
		BoardDTO dto = new BoardDTO();
		dto.setTitle("테스트1 제목");
		dto.setContent("테스트1 내용");
		dto.setWriter("테스트1 작가");
		int result = this.boardMapper.insertBoard(dto);
		log.info("\t + result : {}", result);
	}//insertBoard
	
	@Test
	@Order(2)
	@DisplayName("selectBoard")
	void testselectBoard() throws DAOException {
		BoardVO vo = this.boardMapper.selectBoard(4);
		log.info("\t + vo : {}", vo);
	}//selectBoard

	@Test
	@Order(3)
	@DisplayName("selectAllBoard")
	void testselectAllBoard() throws DAOException{
		List<BoardVO> list = this.boardMapper.selectAllBoard();
		list.forEach(log::info);
	}//selectAllBoard

	@Test
	@Order(4)
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testupdateBoard() throws DAOException{
		BoardDTO dto = new BoardDTO();
		dto.setBno(1);
		dto.setTitle("테스트 수정 제목");
		dto.setContent("테스트 수정 내용");
		dto.setWriter("작가2");
		int result= this.boardMapper.updateBoard(dto);
		log.info("\t + result : {}", result);
	}//updateBoard
	
	@Test
	@Order(5)
	void testdeleteBoard() throws DAOException{
		
		int result = this.boardMapper.deleteBoard(2);
		log.info("\t + result : {}", result);
	}//deleteBoard
	

	
	
}//end class

