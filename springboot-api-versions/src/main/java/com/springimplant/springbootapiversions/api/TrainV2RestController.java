package com.springimplant.springbootapiversions.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springimplant.springbootapiversions.entity.Train2;

@RestController
@RequestMapping("/api/v2")
public class TrainV2RestController {
	
	
@GetMapping("/train")
public Train2 train() {
	return new Train2("Model001", 100.0f,"Lombard");
}


}
