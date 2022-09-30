package com.springimplant.jwt.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.springimplant.jwt.api.entity.Authority;
import com.springimplant.jwt.api.entity.Role;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.entity.type.UserStatus;
import com.springimplant.jwt.api.entity.type.UserType;
import com.springimplant.jwt.api.repository.AuthorityRepository;
import com.springimplant.jwt.api.repository.RoleRepository;
import com.springimplant.jwt.api.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class SpringSecurityJwtApplication {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void initRoles() {
		List<Role> roles = Stream.of(
				new Role(null, "Admin", "Admin", 1L, null, UserType.INTERNAL_GE_USER),
				new Role(null, "SEM Engineer", "SEM Engineer", 2L, null, UserType.INTERNAL_GE_USER),
				new Role(null, "Viewer", "Viewer", 3L, null, UserType.INTERNAL_GE_USER)
				).collect(Collectors.toList());
//		roleRepository.saveAll(roles);
	}
	
	
	@PostConstruct
	public void initUsers() {
		Set<Role> setRoles = new HashSet<Role>();
		Role adminRole = roleRepository.findByName("Admin");
		setRoles.add(adminRole);
		List<User> users = Stream.of(
				new User(null,UserStatus.ACTIVE,"Gaurav","Matta","9891095692","gaurav.matta@ge.com","502553205",false, null, null, setRoles, null,null),
				new User(null,UserStatus.ACTIVE,"Samir","Patkar","9891095692","samir.patkar@ge.com","503331667",false, null, null, setRoles, null,null)
				).collect(Collectors.toList());
//		userRepository.saveAll(users);
	}
	
	@PostConstruct
	public void initAuthorties() {
//		List<Authority> authorities = Stream.of(
//				new Authority(null,"Engine Line Tracker","Engine Line Tracker"),
//				new Authority(null,"Pin a Card","Pin a Card"),
//				new Authority(null,"Upload/Download/Edit","Upload/Download/Edit"),
//				new Authority(null,"Scorecard","Scorecard"),
//				new Authority(null,"Project Plan","Project Plan"),
//				new Authority(null,"Search","Search")
//				).collect(Collectors.toList());
//		authorityRepository.saveAll(authorities);
	}
	


	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
