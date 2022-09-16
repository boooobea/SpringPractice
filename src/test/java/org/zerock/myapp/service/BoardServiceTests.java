package org.zerock.myapp.service;

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
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	@Test
	@DisplayName("createBoard")
	void testcreateBoard() throws ServiceException {
		BoardDTO dto = new BoardDTO();
		dto.setTitle("테스트중입니다.");
		dto.setContent("테스트중인 내용");
		dto.setWriter("작가1");
		int result = this.boardService.createBoard(dto);
		log.info("\t + result : {}", result);
	}//createBoard
	
	@Test
	@Order(2)
	@DisplayName("getBoard")
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testgetBoard() throws ServiceException {
		int bno = 3;
		BoardVO vo = this.boardService.getBoard(bno);
		log.info("\t + vo : {}", vo);
	}//getBoard;
	
	@Test
	@Order(3)
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testgetAllBoard() throws ServiceException{
	
		List<BoardVO> list = this.boardService.getAllBoard();
		list.forEach(log::info);
		
	}//getAllBoard
	
	@Test
	@Order(4)
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testmodifyBoard() throws ServiceException{
		
		BoardDTO dto = new BoardDTO();
		dto.setBno(2);
		dto.setTitle("수정된 제목입니다.");
		dto.setContent("수정된 내용입니다.");
		dto.setWriter("작가3");
		int result = this.boardService.modifyBoard(dto);
		log.info("\t + result : {}", result);
		
	}//modifyBoard

	@Test
	@Order(5)
	@DisplayName("removeBoard")
	@Timeout(value = 5, unit = TimeUnit.SECONDS)
	void testremoveBoard() throws ServiceException{
		
		int result = this.boardService.removeBoard(2);
		log.info("\t + result : {}", result);
	}//removeBoard


}//end class
