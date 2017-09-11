package com.zxq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库的工具类 创建日期：2017/5/6 9:55
 * 
 * @author zxq
 * 
 */
public class DBUtil {
	public static String driverStr = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String connStr = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Student";
	public static String dbusername = "sa";
	public static String dbpassword = "sql";

	public static Connection getConn() {
		Connection connection = null;
		try {
			Class.forName(driverStr);
			connection = DriverManager.getConnection(connStr, dbusername,
					dbpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void close(Statement state, Connection conn) {
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs, Statement state, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}

