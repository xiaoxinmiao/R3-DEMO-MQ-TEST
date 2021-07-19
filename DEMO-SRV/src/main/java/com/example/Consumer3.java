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
public class Consumer3 implements MessageListener {
    @Value("${r3.mq.consumer.default.listener.topic3:com.sample.topic3}")
    public String topic3;
    @Value("${r3.mq.consumer.default.listener.expr3:com.sample.tag}")
    public String expr3;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        return null;
    }
}
