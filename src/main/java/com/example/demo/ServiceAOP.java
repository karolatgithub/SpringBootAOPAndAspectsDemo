package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.testdome.service.BookRepository;
import com.testdome.service.BookSearchService;
import com.testdome.service.RepositoryCallback;
import com.testdome.service.SearchCallback;
import com.testdome.service.ServiceCallback;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServiceAOP {

	@Autowired
	ServiceCallback serviceCallback;
	@Autowired
	SearchCallback searchCallback;
	@Autowired
	RepositoryCallback repositoryCallback;

	public static void main(String[] args) {
		final AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext();
		config.register(ServiceAOP.class, BookSearchService.class, BookRepository.class);
		config.refresh();

		BookSearchService service = config.getBean(BookSearchService.class);
		System.out.println(service.bookExists("Book2"));
		System.out.println(service.bookExists("Book"));
		config.close();
	}
}
