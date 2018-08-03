package dev.peruch.rxjavamongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rx.subjects.PublishSubject;

@SpringBootApplication
public class Runner{

	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
	}

	@Bean
	public PublishSubject publishSubject(){
		return PublishSubject.create();
	}
}
