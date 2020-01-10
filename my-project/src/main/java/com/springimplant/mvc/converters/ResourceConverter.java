package com.springimplant.mvc.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.springimplant.mvc.data.entities.Resource;
import com.springimplant.mvc.data.services.ResourceService;

public class ResourceConverter implements Converter<String, Resource> {

	@Autowired
	private ResourceService service;
	
	@Override
	public Resource convert(String resourceId) {
		// TODO Auto-generated method stub
		return service.find(Long.parseLong(resourceId));
	}

}
