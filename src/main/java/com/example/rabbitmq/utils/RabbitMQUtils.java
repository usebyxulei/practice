package com.example.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQUtils {

    private static  ConnectionFactory connectionFactory;
    static {
        //重量级资源 类加载时执行一次
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.110.130");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }

    public static Connection getConnection(){
        try {

            return connectionFactory.newConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChannel(Channel channel,Connection connection){
        try {
            if (channel != null) channel.close();
            if (connection != null )connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
