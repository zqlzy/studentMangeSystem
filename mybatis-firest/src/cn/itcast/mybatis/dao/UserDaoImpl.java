/**
 * 
 */
package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.pojo.User;

/**
 * @author zql
 *
 */

public class UserDaoImpl implements UserDao {
	//注入工厂
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//
	//通过用户ID查询一个用户
	public User selectUserById(Integer id) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		User user= sqlSession.selectOne("test.findUserById",id);
		sqlSession.close();
		return user;
		
	}

	@Override
	public List<User> queryUserByUsername(String username) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=sqlSessionFactory.openSession();
		// 执行查询逻辑
		List<User> list = sqlSession.selectList("queryUserByUsername", username);
		// 释放资源
		sqlSession.close();
		return list;

		
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		// 创建SqlSession
				SqlSession sqlSession = this.sqlSessionFactory.openSession();

				// 执行保存逻辑
				sqlSession.insert("saveUser", user);
				// 提交事务
				sqlSession.commit();
				// 释放资源
				sqlSession.close();

		
	}
	

}
