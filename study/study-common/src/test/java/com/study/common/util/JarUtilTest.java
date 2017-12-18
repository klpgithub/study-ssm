package com.study.common.util;

import org.junit.Test;

public class JarUtilTest {

	@Test
	public void testDecompress() {
		JarUtil.decompress("D:\\work\\soft\\.m2\\repository\\c3p0\\c3p0\\0.9.1.1\\c3p0-0.9.1.1.jar",
				"D:\\work\\soft\\.m2\\repository\\c3p0\\c3p0\\0.9.1.1");
	}

}
