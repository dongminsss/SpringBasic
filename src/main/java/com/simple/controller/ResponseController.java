package com.simple.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/response")
public class ResponseController {
	
	//1. 화면
	@RequestMapping("/ex01")
	public void ex01() {}
	
	//result01요청
	@RequestMapping("/result01")
	public String result01(ModelMap model) {
		
		model.addAttribute("data", "카리나");
		model.addAttribute("serverTime", new Date());
		
		
		return "response/result01";
	}
	
	//result02 - modelAndView 객체
	@RequestMapping("/result02")
	public ModelAndView result02() {
		//뷰의 정보, data정보를 함께 저장할 수 있는 객체
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", "카리나");
		mv.addObject("name", "윈터");
		mv.setViewName("response/result02");
		
		return mv;
	}
	
	//@ModelAttribute = req + model이 합쳐짐
	@RequestMapping("/result03") 
	public String result03(@ModelAttribute("num") int num) {
		System.out.println("화면데이터: " + num); //화면데이터 : 10
		return "response/result03";
	}
	@RequestMapping("/result04")
	public String result04(@ModelAttribute("test") ReqVO vo) {
		
		return "response/result04";
	}
	
	//////////////////////////////////////////////////////////////////////
	//redirect 이동과 redirectAttribute
	//스프링에서 redirect는 다시 컨트롤러에 태우는 요청입니다.
	//RedirectAttribute는 redirect시에 1회성 데이터를 저장할 수 있습니다.
	
	//화면요청
	@RequestMapping("/redirect_login")
	public String loginView() {
		return "response/redirect_login";
	}
	//로그인 요청
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, 
						@RequestParam("pw") String pw,
						RedirectAttributes ra) {
		
		//로그인 성공 -> home
		if(id.equals(pw)) {
			
			ra.addFlashAttribute("msg","어서와"); //1회성 데이터 
			return "redirect:/"; //다시 home 컨트롤러 태워 보냄 - model을 사용할 순 없음
		//로그인 실패
		} else {
			ra.addFlashAttribute("msg","맞지 않습니다.");
			return "redirect:/response/redirect_login";//"redirect:/절대경로";
		}
	}
	
}
