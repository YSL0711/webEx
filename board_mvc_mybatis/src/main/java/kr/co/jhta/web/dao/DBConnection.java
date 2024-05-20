package kr.co.jhta.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
//싱글톤
	// 디자인 패턴. 혼자만 존재할 수 있음
	// 너무 여러개면 안 되겠어 무거워 할 때 만들어준다.

	// *특징 세 가지
	// 프라이빗 생성자
	// 프라이빗한 자기 자신의 객체를 가지고
	// 프라이빗한 자기 자신의 객체 리턴

	private static DBConnection instance = new DBConnection();
	// private에 접근 가능해짐

//	private DBConnection() {
	// 내 클래스 안에서만 쓸게: private
	// static area
	// 공용변수. 그 클래스에서 전용공간을 따로 가지고 있음.

	/* } */

	public static DBConnection getInstance() {
		return instance;
		// 리턴하는 애를 하나 만들어준다
		// 이렇게 하면 다른 클래스에서도 사용 가능해짐.
	}

	public Connection getConnection() {
		/*
		 * JNDI(Java Naming and Directiory Interface) 디렉토리 서비스에서 데이터 및 객체를 발견하고 참고하기 위한
		 * 자바 API
		 * 
		 * 소스코드(데이터베이스 정보)를 공개하지 않고, 개발자는 톰캣에서, DB ID와 PW를 모르면서 쓰는 것. 운영하는 와스에서. 운영하는 DB
		 * 정보를 몰라도 쓸 수 있음
		 */

		Context initCtx;
		Connection conn = null;

		try {
			initCtx = new InitialContext();
//										찾는다    외부환경에서
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	private DBConnection() {

	}
}
