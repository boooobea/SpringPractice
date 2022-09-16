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
import org.zerock.myapp.domain.PageDTO;
import org.zerock.myapp.exception.ControllerException;
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
	
	//-------------------------------------------------게시글 등록
	@GetMapping("/register")
	public void registerGET() {
		log.trace("regisfer get invoked.");
	}//registerGET
	
	@PostMapping("/register")
	public String registerPOST(BoardDTO dto, RedirectAttributes rttrs) throws ControllerException {
		log.trace("register post invoked.");
		
		try{
			int result = this.boardService.createBoard(dto);
			log.info("\t + Create result : {}", result);
		
			if(result==1) {
				rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"게시글이 등록 되었습니다.");			
			} else {
				rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"오류가 발생 하였습니다.");
			}
			return "redirect:/board/list";
		}catch(Exception e) {throw new ControllerException(e);}
	}//registerPOST
	
	//-------------------------------------------------게시글 목록
//	@GetMapping("/list") 		
//	public void boardList(Model model) throws ControllerException {
//		log.trace("BoardList invoked.");
//		
//		try {
//			List<BoardVO> list = this.boardService.getAllBoard();
//			model.addAttribute(CommonKey.BOARD_LIST,list);
//		}catch(Exception e) {throw new ControllerException(e);}
//	}//boardList
	
	@GetMapping("/list")  //페이징적용
	public void boardList(Model model, Criteria cri) throws ControllerException {
		log.trace("BoardList invoked.");
		
		try {
			List<BoardVO> list = this.boardService.PageList(cri);
			model.addAttribute(CommonKey.BOARD_LIST,list);
			
			PageDTO page = new PageDTO(cri, this.boardService.PageCount(cri));
			model.addAttribute(CommonKey.PAGINATION,page);
			
		}catch(Exception e) {throw new ControllerException(e);}
	}//boardList

	//-------------------------------------------------게시글 조회 / 수정 / 삭제 
	@GetMapping({"/get","/modify"})
	public void getboard(Integer bno, Model model, Criteria cri) throws ControllerException {
		log.trace("getBoard invoked.");
		
		try { 
			model.addAttribute("BOARD",this.boardService.getBoard(bno));
			model.addAttribute("cri",cri);
			
		}catch(Exception e) {throw new ControllerException(e); }
	}//getboard
	
	@PostMapping("/modify")
	public String modifyPOST(BoardDTO dto, RedirectAttributes rttrs, Criteria cri) throws ControllerException{
		log.trace("modify Post invoked.");
		try {
			int result = this.boardService.modifyBoard(dto);
			log.info("\t + result : {}", result);
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"게시글이 수정되었습니다.");
			rttrs.addFlashAttribute("cri",cri);
			
			return "redirect:/board/list";
		} catch(Exception e) {throw new ControllerException(e); }
	}//modifyPOST
	
	@PostMapping("/remove")
	public String removePost(Integer bno, RedirectAttributes rttrs) throws ControllerException {
		log.trace("remove invoked.");
		
		try { 
			this.boardService.removeBoard(bno);
			rttrs.addFlashAttribute(CommonKey.BOARD_RESULT,"삭제가 완료되었습니다.");
			return "redirect:/board/list";
		}catch(Exception e) {throw new ControllerException(e); }
	}//remove
	
	//-------------------------------------------------게시글 등록
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
