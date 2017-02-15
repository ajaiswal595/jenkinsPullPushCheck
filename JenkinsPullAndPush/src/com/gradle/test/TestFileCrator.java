package com.gradle.test;

import java.util.Calendar;
import java.util.Date;

import com.gradle.utility.FileCreator;

public class TestFileCrator {
	public static void main(String[] args) {
		FileCreator fileCreator = new FileCreator();
		Calendar cal=Calendar.getInstance();
		//Date d=cal.getTime();
		System.out.println(cal.getTimeInMillis());
		
		fileCreator.crateTxtFile("myTemp"+cal.getTimeInMillis(), "resource");
	}
}
