package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test1Controller {
	@GetMapping("/welcome")
	public String Welcome() {
		return "Welcome String Boot!";
	}
    
	@RequestMapping("/printname")
    public String getprintName(@RequestParam("name") String name){
        return "Welcome " + name;
    }
	
	 @RequestMapping("/favColor")
	    public String getMyFav(@RequestBody String yourFavColor) {
	        return "My favorite color is " + yourFavColor;
	    }
}
