package com.study.upms.client.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.fusesource.hawtbuf.ByteArrayInputStream;

/**
 * session序列化工具
 * 
 * @author KLP 2018年1月2日下午11:44:08
 */
public class SerializableUtil {

	public static String serialize(Session session) {
		if (null == session) {
			return null;
		}
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(session);
			return Base64.encodeToString(bos.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException("serialize session error ", e);
		}
	}

	public static Session deserialize(String sessionStr) {
		if (StringUtils.isBlank(sessionStr)) {
			return null;
		}
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (Session) ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException("deserialize session error ", e);
		}
	}

}
