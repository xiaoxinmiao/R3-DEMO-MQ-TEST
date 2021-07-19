package com.example;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer2 implements MessageListener {
    @Value("${r3.mq.consumer.default.listener.topic2:com.sample.topic2}")
    public String topic2;
    @Value("${r3.mq.consumer.default.listener.expr2:com.sample.tag}")
    public String expr2;
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        return null;
    }

}
