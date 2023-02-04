package com.simple.basic;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml") //동작시킬 스프링 설정파일
public class JDBCTest {

	@Autowired
	DataSource dataSource;
	
	@Test
	public void testCode01() {
		try {
			//DataSource에서 conn 객체 얻음
			Connection conn = dataSource.getConnection();
			System.out.println(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
