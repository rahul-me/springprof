package com.rvcode.pdfinvo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //This class can accept HTTP requests.
public class MyFirstSpringController {
	
	@GetMapping
	@ResponseBody
	public String index() {
		return "Hello world";
	}
}
