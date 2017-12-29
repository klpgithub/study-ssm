package com.study.upms.rpc.api;

import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsSystem;
import com.study.upms.dao.model.UpmsSystemExample;

/**
 * UpmsSystemService接口 Created by shuzheng on 2017/12/26.
 */
public interface UpmsSystemService extends BaseService<UpmsSystem, UpmsSystemExample> {

	/**
	 * 根据name获取UpmsSystem
	 * 
	 * @author : KLP
	 * @param name
	 * @return
	 */
	UpmsSystem selectUpmsSystemByName(String name);

}