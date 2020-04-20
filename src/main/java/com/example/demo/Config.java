package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.testdome.service.RepositoryCallback;
import com.testdome.service.SearchCallback;
import com.testdome.service.ServiceCallback;

//https://www.concretepage.com/spring/example_enableaspectjautoproxy_spring
//https://docs.spring.io/spring/docs/4.3.12.RELEASE/spring-framework-reference/html/aop.html

@Component
public class Config {
	@Bean
	public ServiceCallback serviceCallback() {
		return (methodName) -> System.out.println(methodName);
	}

	@Bean
	public SearchCallback searchCallback() {
		return (book) -> System.out.println(book);
	}

	@Bean
	public RepositoryCallback repositoryCallback() {
		return () -> System.out.println("Repository called!");
	}

}
