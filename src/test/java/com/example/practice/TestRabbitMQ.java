package com.example.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHelloWorld(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    // work
    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型" + i);
        }
    }

    //fanout
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型发布的消息");
    }

    //route 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的路由key的信息");
    }

    //topic 动态路由 订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","product.save","product.save 路由信息");
    }

}
