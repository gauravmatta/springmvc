package com.springimplant.awslambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springimplant.awslambda.domain.Order;
import com.springimplant.awslambda.domain.Student;
import com.springimplant.awslambda.repository.OrderDao;
import com.springimplant.awslambda.repository.StudentRepository;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Bean
	public MyConsumer myConsumerBean() {
		return new MyConsumer();
	}
	
	@Bean
	public Supplier<List<Student>> studentSupplier(){
		return ()->studentRepository.list();
	}
	
	@Bean
	public Function<String, List<Student>> findByNameFunction() {
		return (input) -> studentRepository.list().stream().filter(student -> student.getNameString().equals(input)).collect(Collectors.toList());
	}
	
	@Bean
	public Supplier<List<Order>> orders(){
		return ()->orderDao.buildOrders();
	}
	
	@Bean
	public Function<String, List<Order>> orderByName(){
		return (input) -> orderDao.buildOrders().stream().filter(order->order.getNameString().equals(input)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
	}

}
