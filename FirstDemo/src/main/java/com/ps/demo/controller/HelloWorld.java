package com.ps.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@GetMapping("/helloworld")
	public String home() {
		return "Hello World DEMO for SpringBoot";
	}
}
