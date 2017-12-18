package com.study.common.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 
 * @author KLP
 * @date 2017年12月18日下午2:46:28
 */
public class JarUtil {

	public static synchronized void decompress(String fileName, String outputPath) {
		// 保证输出路径为目录
		if (!outputPath.endsWith(File.separator)) {
			outputPath += File.separator;
		}
		// 如果不存在输出目录,则创建
		File dir = new File(outputPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// 解压到输出目录
		JarFile jf = null;
		try {
			jf = new JarFile(fileName);
			for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements();) {
				JarEntry je = e.nextElement();
				String outFileName = outputPath + je.getName();
				File f = new File(outFileName);
				if (je.isDirectory()) {
					if (!f.exists()) {
						f.mkdirs();
					}
				} else {
					File pf = f.getParentFile();
					if (!pf.exists()) {
						pf.mkdirs();
					}
					InputStream in = jf.getInputStream(je);
					BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(f));
					byte[] buffer = new byte[2048];
					int nBytes;
					while ((nBytes = in.read(buffer)) > 0) {
						outputStream.write(buffer, 0, nBytes);
					}
					outputStream.flush();
					outputStream.close();
					in.close();
				}
			}
		} catch (IOException e) {
			System.out.println("解压  " + fileName + "出错" + e.getMessage());
		} finally {
			if (jf != null) {
				try {
					jf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
