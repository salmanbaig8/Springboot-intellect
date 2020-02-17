package com.intellect.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.model.UserRequestDTO;
import com.intellect.model.UserResponseDTO;
import com.intellect.service.UserService;

@RestController
@RequestMapping("User")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequest) {

		UserResponseDTO userResponse = new UserResponseDTO();
		 String Userid = userService.addUser(userRequest);
		if (Userid != null) {
			userResponse.setResMsg("The Resource has been created");
			userResponse.setUserId(Userid);
		}

		else {
			userResponse.setResMsg(HttpStatus.CONFLICT.toString());
			userResponse.setUserId(Userid);
		}

		return userResponse;

	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public UserRequestDTO updateUser(@PathParam(value = "id") String id, @RequestBody UserRequestDTO userRequest) {
		UserRequestDTO userRequestDto = userService.update(id,userRequest) ;
		return userRequestDto;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public boolean deleteUser(@PathParam(value = "id") String id, @RequestBody UserRequestDTO userRequest) {
	
		boolean flag = userService.delete(id, userRequest);
		return flag;
	}

}
