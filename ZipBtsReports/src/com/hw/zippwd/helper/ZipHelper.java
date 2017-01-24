package com.hw.zippwd.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Properties;
public class ZipHelper {
	
	String btsReportSourceLocation=null;
	String btsReportAfterZipLocation=null;
	String password=null;
	
	public ZipHelper(){
		
		Properties props = new Properties();
		try {
			FileInputStream fis = new FileInputStream("resource\\config.properties");
			props.load(fis);
			btsReportSourceLocation=props.getProperty("btsReportSourceLocation");
			btsReportAfterZipLocation=props.getProperty("btsReportAfterZipLocation");
			password=props.getProperty("passwordForZip");
			System.out.println(btsReportSourceLocation);
			System.out.println(btsReportAfterZipLocation);
			System.out.println(password);
			
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBtsReportZipFileName(){
		Calendar cal=Calendar.getInstance();
		String dd=(cal.get(Calendar.DATE)>9)?(""+cal.get(Calendar.DATE)):("0"+cal.get(Calendar.DATE));
		String mm=((cal.get(Calendar.MONTH)+1)>9)?(""+(cal.get(Calendar.MONTH)+1)):("0"+(cal.get(Calendar.MONTH)+1));
		String yyyy=""+cal.get(Calendar.YEAR);
		return "btsReports-"+yyyy+mm+dd+".zip";
	}
	
	public String getsourceLocation(){
		return btsReportSourceLocation;
	}
	
public String getTargetLocation(){
	try{
	new File(btsReportAfterZipLocation).mkdirs();
	}catch(Exception ex){
		ex.printStackTrace();
	}
		return btsReportAfterZipLocation;
	}

public String getPassword(){
	return password;
}

}



