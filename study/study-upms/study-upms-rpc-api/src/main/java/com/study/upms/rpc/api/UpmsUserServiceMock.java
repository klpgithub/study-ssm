package com.study.upms.rpc.api;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsUserMapper;
import com.study.upms.dao.model.UpmsUser;
import com.study.upms.dao.model.UpmsUserExample;

/**
* 降级实现UpmsUserService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
