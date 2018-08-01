package dev.peruch.rxjavamongo;

import dev.peruch.rxjavamongo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner{

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}
}
