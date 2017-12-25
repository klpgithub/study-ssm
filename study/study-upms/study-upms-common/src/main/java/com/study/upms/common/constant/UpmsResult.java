package com.study.upms.common.constant;

import com.study.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * 
 * @author KLP
 * @date 2017年12月25日下午3:13:04
 */
public class UpmsResult extends BaseResult {

	public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
		super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
	}

}
