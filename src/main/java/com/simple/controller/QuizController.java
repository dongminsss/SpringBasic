package com.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.QuizVO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("quiz01") //01 화면처리
	public void quiz01() {}
	@RequestMapping("quiz02") //02 화면처리
	public void quiz02() {}
	@RequestMapping("quiz03") //03 화면처리
	public void quiz03() {}
	
	@RequestMapping("quiz03_ok") //03 화면처리
	public void quiz03_ok() {}
	
	
	
	@RequestMapping("sendBirth")
	public String sendBirth(QuizVO vo, Model model) {
		model.addAttribute("year",vo.getYear());
		model.addAttribute("day",vo.getDay());
		model.addAttribute("month",vo.getMonth());
		return "quiz/quiz01_ok";
	}
	
	@RequestMapping(value = "join" , method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id ,
						@ModelAttribute("pw") String pw,
						@ModelAttribute("name") String name,
						@ModelAttribute("email") String eamil) {
		
		return "quiz/quiz02_ok";
	}
	
	@RequestMapping(value = "join2" , method = RequestMethod.POST)
	public String join2(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						Model md, RedirectAttributes ra) {
		
		if(!pw_check.equals(pw)) {
			
			md.addAttribute("msg","비밀번호가 틀렸습니다.");
			return "quiz/quiz03";
		} else if(id.trim().equals("")||pw.trim().equals("")) {
			System.out.println(pw.trim().equals(""));
			md.addAttribute("msg","아이디또는 비밀번호를 입력하세요");
			return "quiz/quiz03";
		} else {
			ra.addFlashAttribute("id" , id);
			return "redirect:/quiz/quiz03_ok"; //리다이렉트인 경우 다시 컨트롤러로 돌아가기 때문에 quiz03_ok 화면처리를 해줘야함
		}
		
	}
}
