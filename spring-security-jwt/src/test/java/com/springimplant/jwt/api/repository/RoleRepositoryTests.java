package com.springimplant.jwt.api.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.longThat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
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
	
	
	
}
