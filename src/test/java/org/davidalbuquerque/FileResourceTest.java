package org.davidalbuquerque;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class FileResourceTest 
{
    @Test
    public void testArchieve() throws IOException 
    {
    	ClassLoader classLoader = getClass().getClassLoader();
    	
    	File inputFile = Paths.get("./pikachu.png").toFile();
    	File outputFile = Paths.get("./pikachu2.png").toFile();
    	
        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
        String encodedString = Base64
          .getEncoder()
          .encodeToString(fileContent);
        
        System.out.println("Sdrubbles");
        System.out.println(encodedString);
 
        // decode the string and write to file
        byte[] decodedBytes = Base64
          .getDecoder()
          .decode(encodedString);
        FileUtils.writeByteArrayToFile(outputFile, decodedBytes);
        
        System.out.println(FileUtils.contentEquals(inputFile, outputFile));
    }
}