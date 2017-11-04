package com.intellect.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.intellect.model.UserRequestDTO;

@Service
public class UserService {

	String uniqueID = UUID.randomUUID().toString();
	Map<String, UserRequestDTO> userMap = new HashMap<>();
	Set<UserRequestDTO> userSet = new HashSet<>();

	public String addUser(UserRequestDTO userRequest) {
		boolean flag;

		if (!userMap.isEmpty()) {
			flag = validateUser(userRequest, userMap);
			if (flag == true) {
				userRequest.setId(uniqueID);
				userRequest.setIsActive(true);
				userMap.put(userRequest.getId(), userRequest);
				return userRequest.getId();
			}
		} else if (userMap.isEmpty()) {
			userRequest.setId(uniqueID);
			userRequest.setIsActive(true);
			userMap.put(userRequest.getId(), userRequest);
			return userRequest.getId();
		}
		return null;

	}

	public boolean validateUser(UserRequestDTO userRequest, Map<String, UserRequestDTO> userMap) {
		boolean flag = false;
		for (Map.Entry<String, UserRequestDTO> entry : userMap.entrySet()) {
			userSet.add(entry.getValue());

		}

		for (UserRequestDTO user : userSet) {
			if (userRequest.getEmail().equalsIgnoreCase(user.getEmail())) {
				return flag;
			} else {
				flag = true;
			}

		}
		return flag;

	}

	public UserRequestDTO update(String id, UserRequestDTO userRequest) {
		for (UserRequestDTO user : userSet) {
			if (user.getId().equalsIgnoreCase(id)) {
				user.setPinCode(userRequest.getPinCode());
				user.setBirthDate(userRequest.getBirthDate());
				return user;
			}
		}
		return null;
	}

	public boolean delete(String id, UserRequestDTO userRequest) {
		boolean flag = false;
		for (UserRequestDTO user : userSet) {
			if (user.getId().equalsIgnoreCase(id)) {
				user.setIsActive(false);
				flag = user.getIsActive();
			}
		}
		return flag;

	}

}
