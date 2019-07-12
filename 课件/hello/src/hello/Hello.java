package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import module.UserModule;
import module.impl.UserModuleImpl;
import pojo.UserDto;

public class Hello extends HttpServlet {
	
	UserModule userModule = new UserModuleImpl();


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
		request.getRequestDispatcher("/index.jsp").forward(request, response);//转发到new.jsp
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

		int age = Integer.parseInt(request.getParameter("age"));
		int id = Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		
		request.getSession().setMaxInactiveInterval(1000*60*30);//设置会话超时时间为半小时（当前会话）
		
		UserDto user = new UserDto();
		user.setId(id+"");user.setName(name);user.setAge(age+"");
		
		try {
			boolean b = userModule.saveNewUser(user);
			if (b) {
				request.setAttribute("msg", "保存成功！");
			} else {
				request.setAttribute("msg", "保存出错！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "保存出错！"+e.getMessage());
		}
		request.getRequestDispatcher("/result.jsp").forward(request, response);//转发到result.jsp
	}

}
