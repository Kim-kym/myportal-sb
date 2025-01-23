package himedia.myportal.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.myportal.repositories.vo.GuestbookVo;
import himedia.myportal.services.GuestbookService;
import himedia.myportal.services.GuestbookServiceImpl;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	private static final Logger logger =
		LoggerFactory.getLogger(GuestbookController.class);
	
	@Autowired
	private GuestbookService guestbookServiceImpl;
	
	@GetMapping({"", "/", "/list"})
	public String list(Model model) {
		List<GuestbookVo> list = 
				guestbookServiceImpl.getMessageList();
		model.addAttribute("list", list);
		
		return "guestbook/list";
	}
	
	
	@PostMapping("/write")
	public String write(@ModelAttribute GuestbookVo vo) {
		logger.debug("Form: " + vo);
		boolean success = guestbookServiceImpl
							.writeMessage(vo);
		logger.debug("Write Result:" + success);
		return "redirect:/guestbook";
	}
	
	@GetMapping("/delete/{no}")
	public String delete(@PathVariable("no") Integer no,
							Model model) {
		logger.debug("Guestbook Delete: " + no);
		return "guestbook/deleteform";
		
	}
	@PostMapping("/delete")
	public String deleteAction(@ModelAttribute GuestbookVo vo) {
		boolean success = guestbookServiceImpl.deleteMessage(vo);
		logger.debug("Delete Result:" + success);
		return "redirect:/guestbook";
	}
}
