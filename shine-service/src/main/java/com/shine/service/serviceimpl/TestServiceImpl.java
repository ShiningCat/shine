package com.shine.service.serviceimpl;

import com.shine.cm.common.bean.TMemUserLoginBean;
import com.shine.service.dao.TMemUserLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shine.cm.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TMemUserLoginDao tMemUserLoginDao;

	@Override
	public String helloWorld() {
		TMemUserLoginBean bean = tMemUserLoginDao.selectByKey(Long.parseLong("11000000000028"));
		return bean.toString();
	}

}
