package com.gradle.utility;

import java.io.File;

public class FileCreator {

	public void crateTxtFile(String fileName, String relativeLocation)
	{
		try{
			 File file=new File(relativeLocation+"/"+fileName+".txt");
			 file.createNewFile();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
