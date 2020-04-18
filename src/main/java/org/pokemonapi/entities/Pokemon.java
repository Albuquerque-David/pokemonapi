package org.pokemonapi.entities;

import java.io.File;
import java.util.Base64;
import java.util.Objects;

import org.apache.commons.io.FileUtils;

public class Pokemon {
	private String name;
	private String description;
	private String base64Img;
	
	public Pokemon()
	{
		
	}
	
	public Pokemon(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getBase64Img() {
		return base64Img;
	}

	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}
	
//	private void imgToString()
//	{
//		String inputFilePath = "test_image.jpg";
//	    String outputFilePath = "test_image_copy.jpg";
//	    
//	    byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
//	    String encodedString = Base64.getEncoder().encodeToString(fileContent);
//	}
//	
//	private void stringToImg()
//	{
//		String inputFilePath = "test_image.jpg";
//	    String outputFilePath = "test_image_copy.jpg";
//	    
//		byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//		FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);
//	}
	

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", description=" + description + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pokemon)) {
            return false;
        }

        Pokemon other = (Pokemon) obj;
        return Objects.equals(other.name, this.name);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

}
