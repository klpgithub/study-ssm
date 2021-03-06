package com.study.common.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * 长度校验
 * 
 * @author KLP
 * @date 2017年12月19日下午3:50:07
 */
public class LengthValidator extends ValidatorHandler<String> implements Validator<String> {

	private int min;
	private int max;
	private String fieldName;

	public LengthValidator(int min, int max, String fieldName) {
		this.min = min;
		this.max = max;
		this.fieldName = fieldName;
	}

	@Override
	public boolean validate(ValidatorContext context, String t) {
		if (null == t || t.length() > max || t.length() < min) {
			context.addError(ValidationError.create(String.format("%s长度必须介于%s~%s之间!", fieldName, min, max))
					.setErrorCode(-1).setField(fieldName).setInvalidValue(t));
			return false;
		}
		return true;
	}
}
