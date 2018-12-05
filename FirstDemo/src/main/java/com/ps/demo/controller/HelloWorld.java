package com.ps.demo.controller;

import com.ps.demo.service.Message;
import com.ps.demo.service.SenderType;
import com.ps.demo.service.SenderTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.ps.demo.configuration.ProperitesResouce;
import com.ps.demo.exception.UserInvalidException;

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
		return this.propertiesResouce.getEmail();
	}
	@GetMapping("/user")
	public String getUserException() {
		throw new UserInvalidException("1");
	}
	@PostMapping("/enum")
	public String enumParam(@RequestBody Message message){
		System.out.printf("controller" + message.getSenderType().name());

		return message.getSenderType().toString();
	}
	@PostMapping("/enumdemo")
	public String enumDemo(@RequestBody SenderType type){
	    return type.toString();
    }
    @InitBinder
	public void initBinder(final WebDataBinder webDataBinder){
        System.out.printf("initbinder runned.");
	    webDataBinder.registerCustomEditor(SenderType.class, new SenderTypeConverter());
    }
}
