package com.ldf.springprak13;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPrak13Application {

	@Value("${student.name}")
	private String name;

	@Value("${student.last_name}")
	private String last_name;

	@Value("${student.group}")
	private String group;

	public static void main(String[] args) {
		SpringApplication.run(SpringPrak13Application.class, args);
	}

	@PostConstruct
	public void init(){
		System.out.println("Student name: " + name);
		System.out.println("Student last_name: " + last_name);
		System.out.println("Student group: " + group);
	}

}
