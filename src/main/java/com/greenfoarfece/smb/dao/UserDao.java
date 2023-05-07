package com.greenfoarfece.smb.dao;

import java.util.List;

import com.greenfoarfece.smb.domain.User;

/**
 * Interface contains basic and custom CRUD for {@link User} entity.
 *
 * @since 14 Mar 2017
 * @version 1.0-SNAPSHOT
 * @author Sayid Sidqi
 */
public interface UserDao extends CommonDao<User, Long> {
	public String insertMutipleUser(List<User> user);

	public User findByUsername(String userName);
	public void updateAuthenticationType(String username, String authType);
}
