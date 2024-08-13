package com.springimplant.cloudfunction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springimplant.cloudfunction.api.Book;
import com.springimplant.cloudfunction.api.Order;
import com.springimplant.cloudfunction.repository.OrderDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringCloudFunctionExampleApplication {

	@Autowired
	private OrderDao orderDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionExampleApplication.class, args);
	}

	@Bean
	Function<String, String> reverse() {
		return input -> new StringBuilder(input).reverse().toString();
	}

	@Bean
	Supplier<Book> getBook() {
		return () -> new Book(101, "Core Java");
	}

	@Bean
	Consumer<String> printMsg() {
		return input -> log.info(input);
	}

	@Bean
	Supplier<List<Order>> orders() {
		return () -> orderDao.buildOrders();
	}

	@Bean
	Function<String, List<Order>> findOrderByName() {
		return input -> orderDao.buildOrders().stream().filter(order -> order.getName().equals(input))
				.collect(Collectors.toList());
	}

}
