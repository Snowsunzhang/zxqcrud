package com.zxq.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zxq.bean.Student;
import com.zxq.util.DBUtil;


public class Studentdao {
	public List<Student> list(){
		String sql = "select * from Student";
		Connection connection = DBUtil.getConn();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Student> students = new ArrayList<Student>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			Student student;
			while (resultSet.next()) {
				student=new Student();
				student.setId(resultSet.getString("ID"));
				student.setName(resultSet.getString("Name"));
				
				students.add(student);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, connection);
		}
		return students;
	}
	public void save(Student student)
	{
		String sql="insert into Student(ID,Name) values('"+student.getId()+"','"+student.getName()+"')";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try {
			state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
	}
	public Student select(String id)
	{
		String sql = "select * from Student where ID='"+id+"'";
		Connection connection = DBUtil.getConn();
		Statement statement = null;
		ResultSet resultSet = null;
		Student student= new Student();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				student=new Student();
				student.setId(resultSet.getString("ID"));
				student.setName(resultSet.getString("Name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, connection);
		}
		return student;
	}
	public void update(Student student,String id)
	{
		String sql="update Student set ID='"+student.getId()+"',Name='"+student.getName()+"'where ID='"+id+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try {
			state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
	}
	public void delete(String id)
	{
		String sql="delete from Student where ID='"+id+"'";
		Connection conn = DBUtil.getConn();
		Statement state = null;
		try {
			state = conn.createStatement();
			state.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, conn);
		}
	}
}
