package com.shine.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.shine.cm.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Override
	public String helloWorld() {
		return "helloWorld";
	}

}
