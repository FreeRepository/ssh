package com.welljoint.dao;

import com.welljoint.entity.User;

public interface UserDao {
	public User find(String userName,String password);
}
