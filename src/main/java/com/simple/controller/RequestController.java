package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ReqVO;

@Controller
@RequestMapping("/request") //메서드 앞에 공통으로 들어가는 요청경로
public class RequestController {
	
	
	
	//String 메서드 - 출력 화면을 직접 지정
//	@RequestMapping("/ex01") //요청경로
//	public String ex01() {
//		
//		return "request/ex01"; //출력경로
//	}
	
	// void메서드 - 요청경로가 출력경로가 됨
	@RequestMapping("/ex01")
	public void ex01() {}
	
	//get만 허용
	//@RequestMapping(value = "basic1", method = RequestMethod.GET)
	@GetMapping("/basic1") //위와 동일
	public String basic1() {
		System.out.println(1);
		return null;
	}
	//post만 허용
	//@RequestMapping(value = "basic2", method = RequestMethod.POST)
	@PostMapping("/basic2") //위와 동일
	public String basic2() {
		
		System.out.println("post만 허용");
		return null;
	}
	//get , post 둘 다 허용
	@RequestMapping("/basic3")
	public String basic3() {
		
		return null;
	}
	////////////////////////////////////////////////////////////////////
	//ex02화면요청
	@RequestMapping("/ex02")
	public String ex02() {
		
		return "request/ex02";
	}
	//1st
	//@RequestMapping(value = "/doAction" , method = RequestMethod.POST)
//	public String doAction(HttpServletRequest request) {
//		//name 파람
//		String name = request.getParameter("name");
//		//age 파람
//		String age = request.getParameter("age");
//		//inter
//		String[] inter = request.getParameterValues("inter");
//		
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(inter.toString());
//		return "request/ex02_ok";
//	}
	//2nd
//	@RequestMapping("/doAction")
//	public String doAction(@RequestParam("name") String name , 
//			@RequestParam("age") int age,
//			@RequestParam(value = "inter", required = false , defaultValue =" " ) List<String> list) {
//		/*
//		 * requestParam은 공백과 null데이터가 전달되면 요청을 거절하게 됩니다. 
//		 * 필수가 아닌 파라미터는 required = false 속성을 지정하면 됩니다.
//		 * 필수가 아닌 파라미터인 경우에는 null or ""을 지정하게 되는데 defaultValue로 기본값을 지정할 수 있습니다.
//		 * 
//		 */
//		
//		
//		System.out.println(age);
//		System.out.println(name);
//		System.out.println(list.toString()); //toString을 쓰는데 아무것도 안쓰고 넘기게 되면 nullPointException이 발생 그래서 defaultValue값을 지정해준다.
//		return "request/ex02_ok";
//	}
	//3rd - 커맨드객체를 통해서 맵핑(넘어오는 데이터 name과 setter명이 같아야 합니다)
	@RequestMapping("/doAction")
	public String doAction(ReqVO vo) {
		System.out.println(vo.toString());
		return "request/ex02_ok";
	}
	
	@RequestMapping("/doSb")
	public String doSb(@RequestParam("id") String id, @RequestParam("pw") String pw) {
		if(id.equals("abc123") && pw.equals("xxx123")) {
			
			return "request/req_quiz01_ok";
		} else {
			System.out.println(id=="abc123");
			System.out.println(pw.equals("xxx124"));
			return "request/req_quiz01_no";
			
		}
	}
	@RequestMapping("/req_quiz01")
	public void req_quiz01() {}
	
	
}
