package com.zxq.serverlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxq.bean.Student;
import com.zxq.dao.Studentdao;

import com.zxq.util.DBUtil;




public class Studentserverlet extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String method = req.getParameter("method");
		
		if ("add".equals(method)) {
			add(req, resp);
		} else if ("delete".equals(method)) {
			delete(req, resp);
		} else if ("edit".equals(method)) {
			edit(req, resp);
		} 
		else if ("edit1".equals(method)) {
			edit1(req, resp);
		} 
		else if ("list".equals(method)) {
			select(req, resp);
		}
	}
	private void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Studentdao studentdao=new Studentdao();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		studentdao.save(student);
		select(req, resp);
	}
	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Studentdao studentdao=new Studentdao();
		List<Student> students=studentdao.list();
		req.setAttribute("students", students);
		req.getRequestDispatcher("studentlist.jsp").forward(req, resp);
		
	}
	private void edit1(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Studentdao studentdao=new Studentdao();
		Student student =new Student();
		String id = req.getParameter("id");
		student=studentdao.select(id);
		req.setAttribute("student", student);
		req.getRequestDispatcher("update.jsp").forward(req, resp);
		
	}
	private void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Studentdao studentdao=new Studentdao();
		Student student =new Student();
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		student=studentdao.select(id);
		student.setId(id);
		student.setName(name);
		studentdao.update(student, id);
		select(req, resp);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Studentdao studentdao=new Studentdao();
		String id = req.getParameter("id");
		studentdao.delete(id);
		select(req, resp);
	}
}
