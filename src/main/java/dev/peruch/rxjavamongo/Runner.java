package dev.peruch.rxjavamongo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(Runner.class, args);
		EntryPointFlow entryPointFlow = new EntryPointFlow();

		entryPointFlow.firstTry();
		entryPointFlow.secondTry();
		entryPointFlow.thirdTry();
	}
}
