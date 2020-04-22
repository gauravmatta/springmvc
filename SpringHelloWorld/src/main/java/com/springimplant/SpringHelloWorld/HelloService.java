package com.springimplant.SpringHelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {

	@RequestMapping(path="/",method = RequestMethod.GET)
	public String index()
	{
		return ("Hello World 2020");
	}
	
	@GetMapping("/abc")
	public String abcService()
	{
		return ("from ABC Service");
	}
}
