package com.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.dao.BoardDAO;
import com.board.domain.BoardVO;
import com.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

 @Inject
 private BoardService service;

 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public void getList(Model model) throws Exception {
  
  List<BoardVO> list = null;
  list = service.list();
  model.addAttribute("list", list);
 }
 
 @RequestMapping(value="/write",method = RequestMethod.GET)
 public void getWrite() throws Exception{
	 
 }
 
 @RequestMapping(value="/write",method = RequestMethod.POST)
 public String postwrite(BoardVO vo) throws Exception{
	 service.write(vo);
	 
		/* 모든 작업을 마치고 list 로 이동 */
	 return "redirect:/board/list";
 }
 @RequestMapping(value="/view",method = RequestMethod.GET)
 public void getView(@RequestParam("bno") int bno,Model model) throws Exception{
		/* RequestParam("가져올 파라미터 이름") 자료형 넣을값이름 */
	 BoardVO vo = service.view(bno);
	 
	 model.addAttribute("view",vo);
 }
 @RequestMapping(value="/modify",method = RequestMethod.GET)
 public void getModify (@RequestParam("bno")int bno, Model model) throws Exception{
	 BoardVO vo = service.view(bno);
	 
	 model.addAttribute("view",vo);
	 
 }
 @RequestMapping(value="/modify",method = RequestMethod.POST)
 public String postModify(BoardVO vo) throws Exception{
	 service.modify(vo);
	 
	 return "redirect:/board/view?bno=" + vo.getBno();
	 
 }
 
 @RequestMapping(value="/delete",method = RequestMethod.GET)
 public String getDelete(@RequestParam("bno")int bno) throws Exception{
	 service.delete(bno);
	
	 return "redirect:/board/list";
 }
}