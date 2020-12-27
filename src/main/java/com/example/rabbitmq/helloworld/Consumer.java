package com.example.rabbitmq.helloworld;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

//    @Test
//    public void testReceiveMessage() throws IOException, TimeoutException {

    public static void main(String[] args) throws IOException, TimeoutException {
       /* // 创建连接mq的连接工厂对象
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接rabbitmq的主机
        connectionFactory.setHost("192.168.110.130");
        //设置端口号
        connectionFactory.setPort(5672);
        //设置连接哪个虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //设置访问虚拟主机的用户名、密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");

        //获取连接对象
        Connection connection = connectionFactory.newConnection();*/

        Connection connection = RabbitMQUtils.getConnection();

        //创建通道
        Channel channel = connection.createChannel();

        //通道绑定对象
        channel.queueDeclare("hello",true,false,false,null);
        //消费消息
        //参数1 消费那个队列的消息 队列名称
        //参数2 开始消息的自动确认机制
        //参数3 消费消息时回调接口
        channel.basicConsume("hello",true, new DefaultConsumer(channel){

            //最后一个参数： 消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body = " + new String(body));
            }
        });
    }


//    }
}

