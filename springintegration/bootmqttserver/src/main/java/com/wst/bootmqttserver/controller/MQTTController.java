package com.wst.bootmqttserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/emq")
public class MQTTController {
	@GetMapping("/mqtt")
	public String greeting(){
		return "Hello";
	}
	
}
