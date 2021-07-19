package com.example;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import com.example.model.IpBTaobaoOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class Consumer1 implements MessageListener {

    @Value("${r3.mq.consumer.default.listener.topic1:com.sample.topic1}")
    public String topic1;
    @Value("${r3.mq.consumer.default.listener.expr1:com.sample.tag}")
    public String expr1;

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        String messageTopic = message.getTopic();
        String messageTag = message.getTag();
        String messageKey = message.getKey();

        log.info("消费1 开始 topic {} tag {} key {} ", messageTopic, messageTag, messageKey);
        try {
            long l1 = System.currentTimeMillis();
            List<IpBTaobaoOrder> ipBTaobaoOrders = (List<IpBTaobaoOrder>) ObjectUtil.objectDeserialize(message.getBody());
            if(CollectionUtils.isEmpty(ipBTaobaoOrders)){
                return Action.CommitMessage;
            }
            long l2 = System.currentTimeMillis();
            log.info("消费1 解析时间 {}ms", (l2 - l1));
            return Action.CommitMessage;
        }catch (Exception e){
            log.error("消费1 异常 {}", ExceptionUtils.getStackTrace(e));
            return Action.ReconsumeLater;
        }
    }
}
