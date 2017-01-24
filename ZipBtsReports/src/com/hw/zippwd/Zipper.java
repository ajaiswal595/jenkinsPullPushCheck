package com.hw.zippwd;

import com.hw.zippwd.helper.ZipHelper;
import com.hw.zippwd.utility.ZipWithPassword;


public class Zipper {
	public static void main(String[] args) {
		
		ZipHelper zh = new ZipHelper();
		ZipWithPassword zwp = new ZipWithPassword();
		zwp.zipDir(zh.getsourceLocation(),zh.getTargetLocation(),zh.getBtsReportZipFileName(),zh.getPassword());
	}
}
