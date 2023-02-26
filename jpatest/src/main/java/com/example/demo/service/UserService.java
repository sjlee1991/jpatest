package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Users> getUsersService(String name) {
    	if(name.isBlank()) 
    		return userRepository.findAll();
    	else
    		return userRepository.findFirst2ByUsernameLikeOrderByIDDesc(name);
    }
    
    public String createUserService(Users user) {
    	userRepository.save(user);
    	return "등록 완료";
    }
}
