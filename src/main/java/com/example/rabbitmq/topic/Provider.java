package com.example.rabbitmq.topic;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        //获取连接
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        //声明交换机以及交换机类型
        channel.exchangeDeclare("topics", BuiltinExchangeType.TOPIC);
        //发布消息
        String routingKey = "user.save";

        channel.basicPublish("topics",routingKey,null,("这里是topic 动态路由模型，routingKey=[" + routingKey + "]").getBytes());

        //关闭资源
        RabbitMQUtils.closeConnectionAndChannel(channel,connection);

    }
}
