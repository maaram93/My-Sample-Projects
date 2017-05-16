package app;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import trng.imcs.beans.Address;
import trng.imcs.beans.Communication;
import trng.imcs.beans.Home;
import trng.imcs.beans.Marks;
import trng.imcs.beans.Student;

public class MarshallingApp {

	public static void main(String[] args) throws JAXBException {
		
		Home home =new Home("Mac",102);
		Communication comm = new Communication("Arthur",201);
		Address add = new Address(home,comm);
		List<Address> address = new ArrayList<>(); 
		address.add(add);
		List<String> sub = new ArrayList<>();
		sub.add("cs");
		sub.add("Physics");
		List<Float> marks = new ArrayList<>();
		marks.add(75f);
		marks.add(87f);
		Student student = new Student(1,"raj",address,new Marks( sub,marks,100f));
		File file = new File("E:\\empfile.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(student, file);
	}

}
