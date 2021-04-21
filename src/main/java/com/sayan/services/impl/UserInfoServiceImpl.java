package com.sayan.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.daos.UserInfoDAO;
import com.sayan.models.UserInfo;
import com.sayan.services.UserInfoService;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDAO userInfoDao;
	
	@Override
	public void addUser(UserInfo userInfo) {
		userInfoDao.addUser(userInfo);
	}

	@Override
	public List<UserInfo> getAllUserInfo() {
		return userInfoDao.getAllUserInfo();
		
	}

	@Override
	public UserInfo findById(int id) {
		return userInfoDao.findById(id);
		
	}

	@Override
	public UserInfo findByIdQuery(int id) {
		return userInfoDao.findByIdQuery(id);
	}

	@Override
	public UserInfo update(UserInfo userInfo, int id) {
		return userInfoDao.update(userInfo, id);
	}

	@Override
	public void delete(int id) {
		userInfoDao.delete(id);

	}

}
