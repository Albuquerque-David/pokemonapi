package org.pokemonapi.utils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;

public class ImageUtils 
{
	public static String ConvertToBase64(File file) throws IOException
	{
		if(file == null || file.isFile() == false)
			throw new IllegalArgumentException("Missing file or directory.");
		
		byte[] fileContent = FileUtils.readFileToByteArray(file);
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);
        
        System.out.println(encodedString);
        return encodedString;
	}
	
	public static void ConvertToFile(String base64String, File outputFile) throws IOException
	{
		if(outputFile == null || outputFile.isFile() == false)
			throw new IllegalArgumentException("Missing file or directory,");
		
		if(base64String == null || base64String.equals(""))
			throw new IllegalArgumentException("Cannot use empty string to convert.");
		
		byte[] decodedBytes = Base64
		          .getDecoder()
		          .decode(base64String);
		        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
	}
}
