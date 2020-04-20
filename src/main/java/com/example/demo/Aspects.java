package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspects {

	@Before(value = "execution(* com.testdome.service.BookSearchService.bookExists(..)) and args(book)")
	public void searchCallback(JoinPoint joinPoint, String book) {
		System.out.println("before bookExists:book=" + book);
	}

}
