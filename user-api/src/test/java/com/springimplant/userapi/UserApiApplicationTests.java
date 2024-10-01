package com.springimplant.userapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springimplant.userapi.postgres.entity.Product;
import com.springimplant.userapi.postgres.entity.User;
import com.springimplant.userapi.postgres.repository.ProductRepository;
import com.springimplant.userapi.postgres.repository.UsersRepository;

@SpringBootTest
class UserApiApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void getData() {
		productRepository.findAll().forEach(product->System.out.println(product.getName()));
		usersRepository.findAll().forEach(user -> System.out.println(user.getEmail()));
	}
	
	
	@Test
	void dbTest() {
		User user = User.builder()
		.firstName("Gaurav")
		.lastName("Matta")
		.email("g@m.com")
		.build();
		Product product = Product.builder()
				.name("Apple Iphone")
				.price(54000)
				.live(true)
				.description("It's an Apple")
				.build();
		usersRepository.save(user);
		productRepository.save(product);
		System.out.println("Data Saved!!!");
	}

}
