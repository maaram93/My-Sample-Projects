package imcs.JSON.App;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import imcs.JSON.POJOS.Address;
import imcs.JSON.POJOS.AddressType;
import imcs.JSON.POJOS.Marks;
import imcs.JSON.POJOS.Student;

public class MarshallingApp {
	
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\rajas\\Documents\\workspace\\JSONProject\\src\\main\\resources\\Student.json"));
         
        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
         
        //convert json string to object
        Student emp = objectMapper.readValue(jsonData, Student.class);
         
        System.out.println("Student Object\n"+emp);
         
       

	}

	
}
