package com.springimplant.essentials.initialbootapp.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.springimplant.essentials.initialbootapp.entities.Greeting;
import com.springimplant.essentials.initialbootapp.entities.HelloMessage;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) {
		return new Greeting("Hello,"+HtmlUtils.htmlEscape(message.getName()));
	}
}
