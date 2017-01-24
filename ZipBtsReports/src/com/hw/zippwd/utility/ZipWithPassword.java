package com.hw.zippwd.utility;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipWithPassword {

	public void zipDir(String sourceFolderLocation,String targetLocation,String targetZipFileName,String password) {

		try {
			// This is name and path of zip file to be created
			//"D:/btsReport.zip"
			ZipFile zipFile = new ZipFile(targetLocation+"/"+targetZipFileName);
			System.out.println("Zipping is started");

			// Initiate Zip Parameters which define various properties
			ZipParameters parameters = new ZipParameters();
			parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE); // set
																			// compression
																			// method
																			// to
																			// deflate
																			// compression

			// DEFLATE_LEVEL_FASTEST - Lowest compression level but higher speed
			// of compression
			// DEFLATE_LEVEL_FAST - Low compression level but higher speed of
			// compression
			// DEFLATE_LEVEL_NORMAL - Optimal balance between compression
			// level/speed
			// DEFLATE_LEVEL_MAXIMUM - High compression level with a compromise
			// of speed
			// DEFLATE_LEVEL_ULTRA - Highest compression level but low speed
			parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA);

			// Set the encryption flag to true
			parameters.setEncryptFiles(true);

			// Set the encryption method to AES Zip Encryption
			parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);

			// AES_STRENGTH_128 - For both encryption and decryption
			// AES_STRENGTH_192 - For decryption only
			// AES_STRENGTH_256 - For both encryption and decryption
			// Key strength 192 cannot be used for encryption. But if a zip file
			// already has a
			// file encrypted with key strength of 192, then Zip4j can decrypt
			// this file
			parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

			// Set password
			parameters.setPassword(password);

			// Now add files to the zip file
			//"G:\\Honeywell Git Repo\\btsReports Build Folder\\btsReports"
			zipFile.addFolder(sourceFolderLocation,parameters);
			// zipFile.addFiles(filesToAdd, parameters);
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}
}
