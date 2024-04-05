package com.springimplant.deadletter.queue;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQSetupStuff {
	
	private static String QUEUE_NAME = "myqueue1";
	private static String DL_QUEUE_NAME = "dlq1";
	private static String Exchange_NAME = "myexchange1";
	private static String DL_Exchange_NAME = "dlx1";
	private static String DL_ROUTING_KEY = "dlrk";
	private static String ROUTING_KEY = "myrk";
	static ConnectionFactory connectionFactory = null;
	
	public static ConnectionFactory getConnectionFactory() {
		if(connectionFactory == null) {
			connectionFactory =  new ConnectionFactory();
			connectionFactory.setHost("localhost");
			connectionFactory.setPort(5672);
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
		}
		return connectionFactory;
	}
	
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = getConnectionFactory().newConnection();
		Channel channel = connection.createChannel();
		Map<String,Object> arguments = new HashMap<>();
		arguments.put("x-message-ttl",20000);
		arguments.put("x-dead-letter-routing-key", DL_ROUTING_KEY + ".test1");
		arguments.put("x-dead-letter-exchange", DL_Exchange_NAME);
		channel.queueDelete(QUEUE_NAME);
		channel.queueDeclare(QUEUE_NAME,true,false,false,arguments);
		channel.exchangeDelete(Exchange_NAME);
		channel.exchangeDeclare(Exchange_NAME, "topic");
		channel.queueBind(QUEUE_NAME,Exchange_NAME, ROUTING_KEY+".#");
		channel.queueDelete(DL_QUEUE_NAME);
		channel.queueDeclare(DL_QUEUE_NAME,true,false,false,new HashMap<>());
		channel.exchangeDelete(DL_Exchange_NAME);
		channel.exchangeDeclare(DL_Exchange_NAME, "topic");
		channel.queueBind(DL_QUEUE_NAME, DL_Exchange_NAME, DL_ROUTING_KEY+".#");
		AMQP.BasicProperties basicProperties =  new AMQP.BasicProperties();
		channel.basicPublish(Exchange_NAME, ROUTING_KEY+".message1", basicProperties, "Hello Message 1".getBytes());
		connection.close();
	}

}
