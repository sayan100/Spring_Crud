package com.sayan.daos;

import java.util.List;

import com.sayan.models.UserInfo;

public interface UserInfoDAO {
	void addUser(UserInfo userInfo);
	List<UserInfo> getAllUserInfo();
	UserInfo findById(int id);
	UserInfo findByIdQuery(int id);
	UserInfo update(UserInfo userInfo,int id);
	void delete(int id);
}
