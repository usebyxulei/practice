package com.example.rabbitmq.workqueue;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.basicQos(1); //每次只能消费一个消息
        channel.queueDeclare("work",true,false,false,null);

        //参数1 队列名称
        // 参数2 消息自动确认 true 消费者自动向rabbitMQ确认消息消费 false 不会自动确认消息
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1-：" + new String(body));

                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
