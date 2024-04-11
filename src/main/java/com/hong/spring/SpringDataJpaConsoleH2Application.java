package com.hong.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.hong.spring.config.AppConfig;
import com.hong.spring.service.CustomerService;
import com.hong.spring.service.BookService;

// import com.hong.spring.entity.Book;
// import java.util.Date;

public class SpringDataJpaConsoleH2Application {

	public static void main(String[] args) {

		// AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		// appContext.scan("net.codejava.spring");
		// appContext.refresh();
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// CustomerService customerService = appContext.getBean(CustomerService.class);
		CustomerService customerService = (CustomerService) appContext.getBean("customerService");
		// customerService.test();
		
		BookService bookService = (BookService) appContext.getBean("bookService");
		bookService.test();
		
		
		appContext.close();
	}

}
