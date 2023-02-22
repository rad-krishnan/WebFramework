package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Day2 {
	
		
	    @Value("${sample.name}")
	    private String a;

	    @GetMapping("/hello")
	    public String hello() {
	        return "Hello " + a + "!";
	    }
	
}