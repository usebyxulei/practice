package com.example.rabbitmq.fanout;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {

    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //通道绑定交换机
        channel.exchangeDeclare("logs",BuiltinExchangeType.FANOUT);

        //临时队列
        String queueName = channel.queueDeclare().getQueue();

        //绑定家交换机和队列
        channel.queueBind(queueName,"logs","");

        //消费消息
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1：" + new String(body));
            }
        });

    }
}
