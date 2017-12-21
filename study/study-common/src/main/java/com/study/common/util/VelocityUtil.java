package com.study.common.util;

import java.io.File;
import java.util.Properties;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

/**
 * Velocity工具类
 * 
 * @author KLP
 * @date 2017年12月21日上午10:10:52
 */
public class VelocityUtil {

	/**
	 * 根据模板生成文件
	 * 
	 * @author : KLP
	 * @param imputVmFilePath
	 * @param outputFilePath
	 * @param context
	 */
	public static void generate(String inputVmFilePath, String outputFilePath, VelocityContext context) {
		try {
			Properties properties = new Properties();
			properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, getPath(inputVmFilePath));
			Velocity.init(properties);
			// VelocityEngine velocityEngine = new VelocityEngine();
			Template template = Velocity.getTemplate(getFile(inputVmFilePath), "utf-8");
			File outputFile = new File(outputFilePath);
			FileWriterWithEncoding writer = new FileWriterWithEncoding(outputFile, "utf-8");
			template.merge(context, writer);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据文件绝对路径获取目录
	 * 
	 * @author : KLP
	 * @param filePath
	 * @return
	 */
	public static String getPath(String filePath) {
		String path = "";
		if (StringUtils.isNotBlank(filePath)) {
			path = filePath.substring(0, filePath.lastIndexOf("/") + 1);
		}
		return path;
	}

	/**
	 * 根据文件绝对路径获取文件
	 * 
	 * @author : KLP
	 * @param filePath
	 * @return
	 */
	public static String getFile(String filePath) {
		String file = "";
		if (StringUtils.isNotBlank(filePath)) {
			file = filePath.substring(filePath.lastIndexOf("/") + 1);
		}
		return file;
	}

}
