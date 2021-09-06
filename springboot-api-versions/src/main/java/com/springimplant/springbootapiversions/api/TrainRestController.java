package com.springimplant.springbootapiversions.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springimplant.springbootapiversions.entity.Train;
import com.springimplant.springbootapiversions.entity.User;

@RestController
@RequestMapping("/api/v1")
public class TrainRestController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/userlist")
	List<User> getUserList(){
		return restTemplate.getForObject("/api/v1/users",List.class);
	}
	
	@GetMapping("/users")
	List<User> getUsers(){
		List<User> ulist=new ArrayList<User>();
		ulist.add(new User(1,"Gaurav","Matta"));
		ulist.add(new User(2,"Samuel","Manhatten"));
		ulist.add(new User(3,"James","Cornetto"));
		ulist.add(new User(4,"Kwality","Walls"));
		ulist.add(new User(5,"Patnitop","Nestle"));
		ulist.add(new User(6,"Parle","G"));
		return ulist;
	}
	
	@GetMapping("/train")
	public Train train() {
		return new Train("Model001", 100.0f);
	}


}
