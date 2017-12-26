package com.study.upms.rpc.service.impl;

import com.study.common.annotation.BaseService;
import com.study.common.base.BaseServiceImpl;
import com.study.upms.dao.mapper.UpmsOrganizationMapper;
import com.study.upms.dao.model.UpmsOrganization;
import com.study.upms.dao.model.UpmsOrganizationExample;
import com.study.upms.rpc.api.UpmsOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* UpmsOrganizationService实现
* Created by shuzheng on 2017/12/26.
*/
@Service
@Transactional
@BaseService
public class UpmsOrganizationServiceImpl extends BaseServiceImpl<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(UpmsOrganizationServiceImpl.class);

    @Autowired
    UpmsOrganizationMapper upmsOrganizationMapper;

}