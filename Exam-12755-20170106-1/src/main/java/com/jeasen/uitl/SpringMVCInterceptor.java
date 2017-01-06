package com.jeasen.uitl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.HandlerInterceptor;

public class SpringMVCInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 用于身份认证，身份授权
		// TODO Auto-generated method stub
		String url = request.getRequestURI();// 获取公开地址（使用时将公开地址配置到配置文件中）
//		System.out.println("url " + url + "indexof" + url.indexOf("login"));
		if (url.indexOf("Login") > 0) {
			// 如果进行了登录提交
			System.out.println("执行了preHandle，已放行");
			return true;
		}
		// 判断session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username"); // 取出数据
		if (username != null) {
//			System.out.println("有用户名，已放行");
			return true;
		}
		request.setAttribute("loginEorrer", "请先登录后再进行操作");
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
