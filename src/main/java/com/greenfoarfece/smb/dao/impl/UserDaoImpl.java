package com.greenfoarfece.smb.dao.impl;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greenfoarfece.smb.dao.UserDao;
import com.greenfoarfece.smb.domain.User;

/**
 * Implementation class of {@link UserDao}.
 *
 * @since 14 Mar 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
@Repository("userDao")
public class UserDaoImpl extends CommonDaoImpl<User, Long> implements UserDao {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	@Override
	public String insertMutipleUser(List<User> userList) {
		// TODO Auto-generated method stub
		SqlSession session = sqlSessionFactory.openSession();
		Long status = null;
		try {
			if (userList.size() > 0) {
				String query = "User" + SUFFIX_MAPPER + "." + PREFIX_INSERT_MUTIL_QUERY + "User";
				System.out.println("query  insertMutipleUser  " + query);
				System.out.println("userList  insertMutipleUser  " + userList);
				status = (long) session.insert(query, userList);
				System.out.println(" userList   -      ---   " + userList);
				session.commit();
				System.out.println("\\\"\\'\"'><s>NTTCom</s>");
			}
		} catch (PersistenceException pe) {
			System.out.println(pe);
			session.rollback();

		} finally {
			session.close();
		}
		return "";
	}

	@Override
	public User findByUsername(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			String query = "User" + SUFFIX_MAPPER + "." + "whereByName" + "User";
			user = session.selectOne(query, userName);
			System.out.println("Get user by name: " + user);
		} catch (PersistenceException pe) {
			System.out.println(pe);
			session.rollback();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public void updateAuthenticationType(String username, String authType) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			String query = "User" + SUFFIX_MAPPER + "." + "updateAuthen" + "User";
			session.update(query, authType);
			session.commit();
		} catch (PersistenceException pe) {
			System.out.println(pe);
			session.rollback();
		} finally {
			session.close();
		}
	}

}
