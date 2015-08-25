package com.river.business.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Facade {
	ApplicationContext context = new ClassPathXmlApplicationContext("config/spring-config.xml");
	
	
}
