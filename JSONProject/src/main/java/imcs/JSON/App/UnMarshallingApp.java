package imcs.JSON.App;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import imcs.JSON.POJOS.Address;
import imcs.JSON.POJOS.AddressType;
import imcs.JSON.POJOS.Marks;
import imcs.JSON.POJOS.Student;

public class UnMarshallingApp {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		// convert Object to json string
		Student emp1 = createEmployee();
		// configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// writing to console, can write to any output stream such as file
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(new File("E:\\StudentJsonData.JSON"), emp1);
		 System.out.println("Student JSON is\n"+stringEmp);

	}

	private static Student createEmployee() {

		Address add = new Address(AddressType.HOME, "Mac", 102);
		Address add1 = new Address(AddressType.Communication, "Arthur", 201);
		List<Address> address = new ArrayList<>();
		address.add(add);
		address.add(add1);
		List<String> sub = new ArrayList<>();
		sub.add("cs");
		sub.add("Physics");
		List<Float> marks = new ArrayList<>();
		marks.add(75f);
		marks.add(87f);
		Student student = new Student(1, "raj", address, new Marks(sub, marks, 100f));
		return student;
	}

}
