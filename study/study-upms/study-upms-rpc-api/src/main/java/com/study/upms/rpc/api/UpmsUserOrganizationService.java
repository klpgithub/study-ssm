package com.study.upms.rpc.api;

import com.study.common.base.BaseService;
import com.study.upms.dao.model.UpmsUserOrganization;
import com.study.upms.dao.model.UpmsUserOrganizationExample;

/**
* UpmsUserOrganizationService接口
* Created by shuzheng on 2017/12/26.
*/
public interface UpmsUserOrganizationService extends BaseService<UpmsUserOrganization, UpmsUserOrganizationExample> {
	
	/**
	 * 用户组织
	 * @author : KLP
	 * @param organizationIds  组织ids
	 * @param id  用户id
	 * @return
	 */
	int organization(String[] organizationIds,int id);
	
}