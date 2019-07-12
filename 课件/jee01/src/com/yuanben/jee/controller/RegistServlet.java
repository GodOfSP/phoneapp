package com.yuanben.jee.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuanben.jee.module.User;
import com.yuanben.jee.module.service.UserService;
import com.yuanben.jee.module.service.impl.UserServiceImpl;

public class RegistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	UserService service = new UserServiceImpl();

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/regist.jsp").forward(request, response);//转发到new.jsp
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String realName = request.getParameter("realName");
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		String address = request.getParameter("address");
		
		User user = new User (userName,password,realName,birthday,address);
		try {
			boolean b = service.saveUser(user);
			if (b) {
				request.setAttribute("msg", "注册成功");
			} else {
				request.setAttribute("msg", "注册失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "注册出错");
		}
		request.getRequestDispatcher("/regist_result.jsp").forward(request, response);//转发到new.jsp
	}

}
