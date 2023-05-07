package com.greenfoarfece.smb.service;

import java.util.List;

import com.greenfoarfece.smb.domain.User;

/**
 * Interface provides business logic of {@link User}.
 */
public interface UserService {

	public List<User> getUser();
	public String insertMutipleUser(List<User> user);
	public void insertUser(User user);

	public User getUserById(Long userId);

	public User findByUsername(String userName);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Long userId);
	List<User> insertMutipleUser();

}
