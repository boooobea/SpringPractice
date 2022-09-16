package org.zerock.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.myapp.common.CommonKey;
import org.zerock.myapp.domain.BoardDTO;
import org.zerock.myapp.domain.BoardVO;
import org.zerock.myapp.domain.Criteria;
import org.zerock.myapp.exception.ServiceException;
import org.zerock.myapp.service.BoardService;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@Controller
@RequestMapping("/board/")
public class BoardController {

	@Setter(onMethod_ = @Autowired)
	private BoardService boardService;
	
	//-----------------------------------------------------------
	
	@GetMapping("/register")
	public void registerGET() throws ServiceException{
		log.trace("regisfer get invoked.");
	}//registerGET
	
	@PostMapping("/register")
	public String registerPOST(BoardDTO dto, RedirectAttributes rttrs) throws ServiceException{
		log.trace("register post invoked.");
		
		int result = this.boardService.createBoard(dto);
		log.info("\t + Create result : {}", result);
		
		if(result==1) {
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"게시글이 등록 되었습니다.");			
		} else {
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"오류가 발생 하였습니다.");
		}
		return "redirect:/board/list";
	}//registerPOST
	
	@GetMapping("/list") 		
	public void boardList(Model model) throws ServiceException {
		log.trace("BoardList invoked.");
		
		List<BoardVO> list = this.boardService.getAllBoard();
		model.addAttribute(CommonKey.BOARD_LIST,list);
		
	}//boardList
	
	@GetMapping({"/get", "/modify"})
	public void board(Integer bno, Model model, Criteria cri) throws ServiceException {
		log.trace("getBoard invoked.");
		
		String cripage = "?currPage="+cri.getCurrPage()+"&keyword="+cri.getKeyword()+"&type="+cri.getType();
		
		model.addAttribute("BOARD",this.boardService.getBoard(bno));
//		return "/board/get"+cripage;
		
	}//board
	
	@PostMapping("/modify")
	public String modifyPost(Criteria cri, BoardDTO dto, RedirectAttributes rttrs) throws ServiceException{
		log.trace("modify Post invoked.");
		
		String cripage = "?currPage="+cri.getCurrPage()+"&keyword="+cri.getKeyword()+"&type="+cri.getType();
		
		int result = this.boardService.modifyBoard(dto);
		log.info("\t + result : {}", result);
		rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"게시글이 수정되었습니다.");
		
		return "redirect:/board/list"+cripage;
	}//modify
	
	@PostMapping("/remove")
	public String removePost(Criteria cri, Integer bno, RedirectAttributes rttrs) throws ServiceException{
		log.trace("remove invoked.");
		
		String cripage = "?currPage="+cri.getCurrPage()+"&keyword="+cri.getKeyword()+"&type="+cri.getType();
		
		if(this.boardService.removeBoard(bno)==1){
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"삭제가 완료되었습니다.");
		} else {
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"삭제 되지 않았습니다.");
		}
		
		return "redirect:/board/list"+cripage;
	}//remove
	
	//댓글쓰기
	@GetMapping("/repliesEnroll2")
	public String repliesEnrollWindowGET(int bno, Model model) throws ServiceException {
		
		
		BoardVO vo = this.boardService.getBoard(bno);
		log.info("\t + reple vo : {}", vo);
		model.addAttribute("bno",bno);
		model.addAttribute("boardVO", vo);
		
		return "/repliesEnroll";
	}//repliesEnroll
	
}//end class
