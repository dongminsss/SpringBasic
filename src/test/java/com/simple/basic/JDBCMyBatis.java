package com.simple.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.simple.basic.mapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class) //junit으로 테스트환경을 구성
@ContextConfiguration("file:src/main/webapp/WEB-INF/config/root-context.xml")
public class JDBCMyBatis {
	
	@Autowired
	SqlSessionFactoryBean ssfb;
	@Autowired
	TestMapper testMapper;
	
	@Test
	public void testCode01() {
		
		//마이바티스 핵심 객체
		System.out.println(testMapper.getTime());
		
		
	}
	
}
