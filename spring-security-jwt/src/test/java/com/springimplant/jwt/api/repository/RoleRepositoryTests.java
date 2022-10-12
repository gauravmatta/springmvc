package com.springimplant.jwt.api.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.springimplant.jwt.api.entity.Role;
import com.springimplant.jwt.api.entity.type.UserType;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class RoleRepositoryTests {

	@Autowired
	private RoleRepository repository;
	
	@Test
	 void testCreateRoles() {
		Role readOnly = new Role(null,"ReadOnly","ReadOnly",4L,null,UserType.INTERNAL_USER);
		Role customer = new Role(null,"Customer","Customer",4L,null,UserType.INTERNAL_USER);
		repository.saveAll(Arrays.asList(readOnly,customer));
		long numberOfRoles = repository.count();
		assertTrue(numberOfRoles>0);
	}
	
	@Test
	void testListRoles() {
		List<Role> listRoles=repository.findAll();
		assertThat(listRoles).isNotEmpty();
		listRoles.forEach(System.out::println);
	}
	
}
