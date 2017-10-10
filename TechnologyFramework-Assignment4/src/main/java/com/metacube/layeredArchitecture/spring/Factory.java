package main.java.com.metacube.layeredArchitecture.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	private static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("WEB-INF/ApplicationContext.xml");
	}

	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}
}