package com.study.upms.rpc.api;

import com.study.common.base.BaseServiceMock;
import com.study.upms.dao.mapper.UpmsLogMapper;
import com.study.upms.dao.model.UpmsLog;
import com.study.upms.dao.model.UpmsLogExample;

/**
* 降级实现UpmsLogService接口
* Created by shuzheng on 2017/12/26.
*/
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
