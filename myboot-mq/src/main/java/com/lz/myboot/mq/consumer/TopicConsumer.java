package com.lz.myboot.mq.consumer;

import com.lz.myboot.mq.constant.MQConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicConsumer {

    @RabbitListener(queues = MQConst.TOPIC_QUEUENAME1)
    @RabbitHandler
    public void process1(String message) {
        log.info("队列:topic.message1,消息:" + message);
    }

    @RabbitListener(queues = MQConst.TOPIC_QUEUENAME2)
    @RabbitHandler
    public void process2(String message) {
        log.info("队列:topic.message2,消息:" + message);
    }
}