package com.springboot.springrabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class SpringRabbitmqConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitmqConsumerApplication.class, args);
	}

}
