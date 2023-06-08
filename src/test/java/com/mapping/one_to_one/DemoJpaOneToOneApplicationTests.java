package com.mapping.one_to_one;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mapping.one_to_one.entity.Laptop;
import com.mapping.one_to_one.entity.Student;
import com.mapping.one_to_one.repository.LaptopRepository;
import com.mapping.one_to_one.repository.StudentRepository;

@SpringBootTest
class DemoJpaOneToOneApplicationTests {

	@Autowired
	private StudentRepository std_repository;
	
	@Autowired
	private LaptopRepository lap_repository;
	
	@Test
	void saveDetails() {
		Student s_1 = new Student();
		s_1.setStdId(101);
		s_1.setStdName("chetan");
		s_1.setStdUSN("01FE19BCV415");
		
		Laptop l_1 = new Laptop();
		l_1.setLapId(501);
		l_1.setModelNumber("Dell Inspiron 1503");
		l_1.setLapBrand("Dell");
		
		Student s_2 = new Student();
		s_2.setStdId(102);
		s_2.setStdName("chinmay");
		s_2.setStdUSN("01FE19BCV410");
		
		Laptop l_2 = new Laptop();
		l_2.setLapId(502);
		l_2.setModelNumber("Lenovo UTW532");
		l_2.setLapBrand("Lenovo");
		
		// foregin key is managing inside student table 
		s_1.setLaptop(l_1);
		s_2.setLaptop(l_2);
		
		std_repository.saveAll(List.of(s_1,s_2));
	}
	
	@Test
	void GetAllDetails(){
		Student s = std_repository.findById(101).get();
		
		System.out.println("****** << Student Details >>******");
		System.out.println(s.getStdId());
		System.out.println(s.getStdName());
		System.out.println(s.getStdUSN());
		
		Laptop l = s.getLaptop();
		System.out.println("******** << Laptop Details >> ******");
		System.out.println(l.getLapId());
		System.out.println(l.getModelNumber());
		System.out.println(l.getLapBrand());
		
	}
	
	@Test
	void DeleteRecord() {
		/*
		 * worked , cascadeType = ALL , which means student table is having foreign key
		 * which means if we delete student then laptop will also gets deleted automatically 
		 */
		int id = 101;
		std_repository.deleteById(id);
	}
	
	@Test
	void DeleteLapRecord() {
		/*
		 * worked , cascadeType = ALL , which means if we try to delete a record
		 * form laptop based on id , corresponding student is also gets deleted
		 */
		
		int id = 502;
		lap_repository.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
