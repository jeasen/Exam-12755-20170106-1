package com.jeasen.controll;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeasen.pojo.User;
import com.jeasen.service.FilmService;

@Controller
public class LoginControll {
	
	@Resource
	FilmService filmService;
	
	@RequestMapping("/showJsp")
	public String showjsp(){
		return "login";
	}
	
	@RequestMapping("/Login")
	public	String judgeLogin(HttpServletRequest request,Model model,Map<String, Object> map) throws ServletException, IOException{
		String username = request.getParameter("username");
		System.out.println("用户名"+username);
		
		
		User i = filmService.selectUsername(new User(username));
		System.out.println("登录返回"+i);
		if( i == null){
			model.addAttribute("error", "输入信息不正确，请重新输入！");
			return "redirect:/login.html";
		}else{
			//这里已经登录成功了
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			return "redirect:/showlist"; //FilmControll
		}
	}
}
