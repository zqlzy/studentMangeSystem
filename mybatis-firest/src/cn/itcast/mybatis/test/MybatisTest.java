package cn.itcast.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.pojo.User;

public class MybatisTest {

	//成员变量
	
	
	@Test
	public void testUpdateUserById() throws Exception {
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//执行Sql语句 
		
		User user=new User();
		user.setUsername("张全羚");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setAddress("中国");
	   int i= sqlSession.insert("test.saveUser", user);
	   sqlSession.commit();
		System.out.println(user.getId());
	
	}
}
