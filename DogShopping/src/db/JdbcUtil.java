package db;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	static {
		// static 요것은 클래스를 읽자마자 바로 실행되는 영역이다.
		// 즉, 클래스를 읽자마자 oracle drive를 바로 읽어들이려고 하는 것이다.
		// forName() 메소드는 괄호안에 있는 클래스를 메모리에 로딩하는 것이다.
		// forName() 처리를 하면 반드시 예외처리를 해줘야한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* 
	 //Connection pool 기능을 사용하지 않은 버전.
	public static Connection getConnection() {
		// db 연결 작업을 해주는 것.
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
											  "java",
											  "java");
			System.out.println("Connection Success!!");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	*/
	
	 //Connection pool 기능을 사용한  버전.
	public static Connection getConnection() {	
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
		      // 톰켓 자체의 컨텍스틑 얻어옴
		      Context envCtx = (Context) initCtx.lookup("java:comp/env");
		      // Resource 정의 컨텍스를 얻어옴 
		      DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
		      con = ds.getConnection();		      
			con.setAutoCommit(false);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	 
	
	public static void close(Connection con) {
		// 여기서 예외처리를 해주자.
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) {
		// 여기서 예외처리를 해주자.
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void close(ResultSet rs) {
		// 여기서 예외처리를 해주자.
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 트랜잭션 처리 부분
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
   
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

























