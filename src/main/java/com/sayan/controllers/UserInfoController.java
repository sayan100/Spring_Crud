package com.sayan.controllers;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.sayan.models.UserInfo;
import com.sayan.services.UserInfoService;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@GetMapping(path="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> getUserById(@PathVariable("id") int id){
		UserInfo userInfo=userInfoService.findById(id);
		if(userInfo == null) {
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserInfo>(userInfo,HttpStatus.OK);
	}
	
	@GetMapping(path="/byquery/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserInfo> getUserByIdQuery(@PathVariable("id") int id){
		UserInfo userInfo=userInfoService.findByIdQuery(id);
		if(userInfo == null) {
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserInfo>(userInfo,HttpStatus.OK);
	}
	
	@PostMapping(path="/create",headers = "Accept=appplication/json")
	public ResponseEntity<Void> createUser(@RequestBody UserInfo userInfo, UriComponentsBuilder builder){
		userInfoService.addUser(userInfo);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/userinfo/{id}").buildAndExpand(userInfo.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
    @GetMapping(path="/getall")
	public List<UserInfo> getAllUserInfo(){
    	return userInfoService.getAllUserInfo();
    }
    
    @PutMapping(path="/update/{id}")
	public ResponseEntity<String> updateUserInfo(@RequestBody UserInfo currentUserInfo, @PathVariable("id") int id){
    	UserInfo userInfo = userInfoService.findById(id);
    	if(userInfo == null) {
			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
		}
		userInfoService.addUser(userInfo);
		HttpHeaders headers = new HttpHeaders();
		userInfoService.update(currentUserInfo, id);
		return new ResponseEntity<String>("User Deleted",HttpStatus.NO_CONTENT);
	}
    
    @DeleteMapping(path="/delete/{id}")
   	public ResponseEntity<String> deleteUserInfo(@PathVariable("id") int id){
       	UserInfo userInfo = userInfoService.findById(id);
       	if(userInfo == null) {
   			return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
   		}
   		userInfoService.delete(id);
   		return new ResponseEntity<String>("User Deleted",HttpStatus.NO_CONTENT);
   	}
    
	
	

}
