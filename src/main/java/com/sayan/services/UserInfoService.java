package com.sayan.services;

import java.util.List;

import com.sayan.models.UserInfo;

public interface UserInfoService {
	void addUser(UserInfo userInfo);
	List<UserInfo> getAllUserInfo();
	UserInfo findById(int id);
	UserInfo findByIdQuery(int id);
	UserInfo update(UserInfo userInfo,int id);
	void delete(int id);
}
