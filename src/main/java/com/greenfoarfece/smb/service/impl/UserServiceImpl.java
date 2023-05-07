package com.greenfoarfece.smb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfoarfece.smb.dao.UserDao;
import com.greenfoarfece.smb.domain.User;
import com.greenfoarfece.smb.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUser() {
        return userDao.findAll();
    }

    @Override
    public void insertUser(User user) {
        // TODO Auto-generated method stub
        userDao.insert(user);
    }

    @Override
    public User getUserById(Long userId) {
        // TODO Auto-generated method stub
        return userDao.find(userId);
    }

    @Override
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateUser(User user) {
        User userser = userDao.find(user.getUserId());
        System.out.println("user.getUserId() =   "+user.getUserId());
        System.out.println("userser = =   "+userser);
        if(userser !=null ) {
            userDao.update(user);
        }

    }

    @Override
    public void deleteUser(Long userId) {
        userDao.delete(userId);

    }


    @Override
    public String insertMutipleUser(List<User> userList) {
        // TODO Auto-generated method stub
        return userDao.insertMutipleUser(userList);
    }

    @Override
    public List<User> insertMutipleUser() {
        // TODO Auto-generated method stub
        return null;
    }

}
