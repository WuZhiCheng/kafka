package com.kafka.consume1;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Consume1Application {

	public static void main(String[] args) {
		SpringApplication.run(Consume1Application.class, args);
	}

	@KafkaListener(id = "t1", topics = "topic-test222",groupId = "22222")
	public void listenT22(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("消费者22222：：：：："+cr.topic()+",,"+cr.key()+",,,,"+cr.value());
	}
}
