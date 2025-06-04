package com.yedam.common;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	public static SqlSessionFactory getInstance() {
		
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory //
				= new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
}
