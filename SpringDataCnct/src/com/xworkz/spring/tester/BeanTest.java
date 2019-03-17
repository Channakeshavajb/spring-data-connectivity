package com.xworkz.spring.tester;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xworkz.spring.dao.BookDAO;
import com.xworkz.spring.dto.BookDTO;

public class BeanTest {

	public static void main(String[] args) {
		ApplicationContext container=new ClassPathXmlApplicationContext("resource/context.xml");
		BookDTO dto=container.getBean(BookDTO.class);
		BookDAO dao=container.getBean(BookDAO.class);
		dao.save(dto);
	}

}
