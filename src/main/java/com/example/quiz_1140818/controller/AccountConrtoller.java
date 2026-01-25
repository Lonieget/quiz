package com.example.quiz_1140818.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.quiz_1140818.request.BasicReq;
import com.example.quiz_1140818.request.UserReq;
import com.example.quiz_1140818.response.BasicRes;
import com.example.quiz_1140818.service.AccountService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
public class AccountConrtoller {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "quiz/add_info")
	public BasicRes addInfo (@Valid @RequestBody UserReq req) {
		return accountService.addInfo(req.getAccount(), req.getPassword(),req.getName(),req.getPhone(),req.getEmail(),req.getAge(),req.getGender());
	}
	
	@PostMapping(value = "quiz/login") //串好了
	public BasicRes login(@Valid @RequestBody BasicReq req) {
		return accountService.login(req.getAccount(), req.getPassword());
	}
		
		

}
