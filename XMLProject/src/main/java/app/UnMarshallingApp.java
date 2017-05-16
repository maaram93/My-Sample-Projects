package app;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import trng.imcs.beans.Student;

public class UnMarshallingApp {

	public static void main(String[] args) throws JAXBException {
		File file = new File("E:\\empfile.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		 Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();
		 Student student = (Student)jaxbUnMarshaller.unmarshal(file);
		 System.out.println(student);
	}


	}


