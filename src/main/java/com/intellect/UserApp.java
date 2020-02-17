package com.intellect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(UserApp.class, args);
	}

}
