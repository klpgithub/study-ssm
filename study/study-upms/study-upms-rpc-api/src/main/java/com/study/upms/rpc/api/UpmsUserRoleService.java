package com.study.upms.rpc.api;

import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsUserRole;
import com.study.upms.dao.model.UpmsUserRoleExample;

/**
* UpmsUserRoleService接口
* Created by shuzheng on 2017/12/26.
*/
public interface UpmsUserRoleService extends BaseService<UpmsUserRole, UpmsUserRoleExample> {
	
	/**
	 * 用户角色
	 * @author : KLP
	 * @param roleIds 角色ids
	 * @param id 用户id
	 * @return
	 */
	int role(String[] roleIds,int id);
}