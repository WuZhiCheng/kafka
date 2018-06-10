package com.example.kafka.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.Date;
import java.util.UUID;

/**
 * 生产者
 * 使用@EnableScheduling注解开启定时任务
 */
@Component
@EnableScheduling
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 定时任务
     */
    @Scheduled(cron = "00/1 * * * * ?")
    public void send(){
        String message = UUID.randomUUID().toString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age",18);
        jsonObject.put("time",System.currentTimeMillis());
        String resule = jsonObject.toJSONString();
        ListenableFuture future = kafkaTemplate.send("ecplogs", resule);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + resule),
                throwable -> System.out.println("消息发送失败：" + resule));

       /* ListenableFuture future = kafkaTemplate.send("ecplogs", "修改/添加"+message);
        future.addCallback(o -> System.out.println("send-消息发送成功：" + message),
                throwable -> System.out.println("消息发送失败：" + message+",,"+new Date()));*/
    }


/*    public void send2(){
        kafkaTemplate.send(new KeyedMessage<String, String>("order",
                "the message no is" + i));

    }*/



}
