package com.springimplant.springbootstarter.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.springbootstarter.entities.Topic;

@RestController
@RequestMapping("/topic")
public class TopicController {

	@RequestMapping("/all")
	public List<Topic> showAll()
	{
		List<Topic> topicList=new ArrayList();
		for (int i=0; i<10; i++) 
		{ 
			topicList.add(new Topic("Sno."+i,"Topic "+i,"Description for Topic "+i));
		}
		return topicList;
	}
}
