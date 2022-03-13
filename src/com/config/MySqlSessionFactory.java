package com.config;
// Confiuration.xml을 읽어와서 SQLSessionFactory를 반환해주고
// 거의 정형적인 패턴의 파일  파일명정도 바뀔것
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
    static SqlSessionFactory sqlSessionFactory;
	static {
		String resource = "com/config/Configuration.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
	}//end static 블럭
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}
