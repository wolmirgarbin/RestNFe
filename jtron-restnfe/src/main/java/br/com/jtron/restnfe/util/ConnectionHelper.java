package br.com.jtron.restnfe.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionHelper {
		
	public static Connection getConnection()  {
		
		Connection conn = null;
		try {
			InitialContext initialContext = new InitialContext();
			Context context = (Context) initialContext.lookup("java:comp/env");
			DataSource ds = (DataSource) context.lookup("jdbc/RestNFe");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection con) {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps) {
		try {
			if (ps != null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void rollback(Connection con){		
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
}