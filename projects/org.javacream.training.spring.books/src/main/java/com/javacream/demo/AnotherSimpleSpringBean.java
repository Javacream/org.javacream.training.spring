package com.javacream.demo;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class AnotherSimpleSpringBean {

	@PostConstruct
	public void init() {
		System.out.println("************************   intializing " + this);
	}
}
