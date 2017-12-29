package com.study.upms.rpc.service.impl;

import com.study.common.annotation.BaseService;
import com.study.common.base.BaseServiceImpl;
import com.study.upms.dao.mapper.UpmsSystemMapper;
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;
import com.study.upms.rpc.api.UpmsSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsSystemService实现
* Created by shuzheng on 2017/12/26.
*/
@Service
@Transactional
@BaseService
public class UpmsSystemServiceImpl extends BaseServiceImpl<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

    private static Logger _log = LoggerFactory.getLogger(UpmsSystemServiceImpl.class);

    @Autowired
    UpmsSystemMapper upmsSystemMapper;

	@Override
	public UpmsSystem selectUpmsSystemByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}