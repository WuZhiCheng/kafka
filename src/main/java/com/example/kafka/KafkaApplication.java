package com.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	/**机制：
	 * https://www.cnblogs.com/yinchengzhe/p/5111648.html
	  介绍：
	 https://www.cnblogs.com/hnylj/p/5475505.html

	 elk:
	 https://blog.csdn.net/u013112651/article/details/72736209

	 api:
	 https://blog.csdn.net/yjh314/article/details/78501114


*/
/**
 如果所有的consumer都具有相同的group,这种情况和JMS(Java Message Service) queue模式很像;消息将会在consumers之间负载均衡.
 如果所有的consumer都具有不同的group,那这就是"发布-订阅";消息将会广播给所有的消费者.
*/
	/*@KafkaListener(id = "t2", topics = "topic-test222",groupId = "22222")
	public void listenT22(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("消费者22222：：：：："+cr.topic()+",,"+cr.key()+",,,,"+cr.value());
	}

	@KafkaListener(id = "t1", topics = "topic-test222",groupId = "22222")
	public void listenT1(ConsumerRecord<?, ?> cr) throws Exception {
		System.out.println("消费者：：：：："+cr.topic()+",,"+cr.key()+",,,,"+cr.value());
	}*/

}
