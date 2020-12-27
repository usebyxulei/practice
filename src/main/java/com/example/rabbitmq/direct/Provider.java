package com.example.rabbitmq.direct;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {

    public static void main(String[] args) throws IOException {
        //获取连接对象
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接通道对象
        Channel channel = connection.createChannel();

        String exchangeName = "logs_direct";

        //通过通道声明交换机 参数1：交换机名称 参数2：路由名称
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);

        //发送消息
        String routingKey = "error111";
        channel.basicPublish(exchangeName,routingKey,null,("这是direct模型发布的基于route key:[" + routingKey + "] 发送的消息").getBytes());

        //关闭资源
        RabbitMQUtils.closeConnectionAndChannel(channel,connection);
    }
}













