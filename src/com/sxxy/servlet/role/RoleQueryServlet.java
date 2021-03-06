package com.sxxy.servlet.role;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.RoleInfo;
import com.sxxy.service.RoleService;
import com.sxxy.service.impl.RoleServiceImpl;

public class RoleQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RoleQueryServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//处理乱码
		request.setCharacterEncoding("utf-8");
		//获取页面文本框的值
		String rolename= request.getParameter("roleName"); 
		System.out.println("servlet:"+rolename);
		
		//业务逻辑
		RoleService service = new RoleServiceImpl();
		//根据条件查询部门信息
		List<RoleInfo> list = service.getList(rolename);
	
		//存放到request
		request.setAttribute("list", list);
		
		//转发
		request.getRequestDispatcher("/view/role/role_list.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
