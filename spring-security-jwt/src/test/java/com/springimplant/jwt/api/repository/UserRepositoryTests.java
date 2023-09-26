package com.springimplant.jwt.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.springimplant.jwt.api.entity.Role;
import com.springimplant.jwt.api.entity.User;
import com.springimplant.jwt.api.entity.type.UserStatus;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UserRepositoryTests {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Test
	void testCreateUser() {
		Set<Role> setRoles = new HashSet<Role>();
		Role adminRole = roleRepository.findByName("Admin");
		setRoles.add(adminRole);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPasswordString = "502553207";
		String encodedPasswordString = passwordEncoder.encode(rawPasswordString);
		User newUser =new  User(null,UserStatus.ACTIVE,"Sourabh","Nigam","9891095692","biraj.das@ge.com",rawPasswordString,false, null, null, setRoles, null,encodedPasswordString);
		User savedUser=userRepository.save(newUser);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getId()).isPositive();
	}
	
	@Test
	void testAssignRolesToUser() {
		Integer userId = 503331667;
		Long roleId = (long) 52;
		
		User user = userRepository.findByUserId(userId.toString()).get();
		user.addRole(new Role(roleId));
		
		User updatedUser =  userRepository.save(user);
		assertThat(updatedUser.getRoles()).hasSizeGreaterThan(1);
	}
}
