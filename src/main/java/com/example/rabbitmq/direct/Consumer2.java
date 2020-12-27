package com.example.rabbitmq.direct;

import com.example.rabbitmq.utils.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "logs_direct";

        //声明交换机 以及交换机类型
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT);

        //创建一个临时的队列
        String queue = channel.queueDeclare().getQueue();
        //临时队列和交换机绑定
        channel.queueBind(queue,exchangeName,"info");
        channel.queueBind(queue,exchangeName,"warning");
        channel.queueBind(queue,exchangeName,"error");

        //消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2:" + new String(body));
            }
        });
    }
}
