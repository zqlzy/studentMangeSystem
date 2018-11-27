package cn.itcast.mybatis.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.mapper.UserMapper;
import cn.itcast.mybatis.pojo.User;

public class MybatisMapperTest {
	
	@Test
	public void testMapper() throws Exception{
	//加载核心配置文件
			String resource = "sqlMapConfig.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			//创建SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
			//创建SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
			User user=userMapper.findUserById(1);
			System.out .println(user);
	}

}
