package com.ps.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.demo.configuration.ProperitesResouce;

@RestController
public class HelloWorld {
	@Autowired
	private ProperitesResouce propertiesResouce;
	@GetMapping("/helloworld")
	public String home() {
		return "Hello World DEMO for SpringBoot";
	}
	@GetMapping("/properties/name")
	public String getProperties() {
		return this.propertiesResouce.getName();
	}
}
