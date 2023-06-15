package ru.orderservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.basedomains.dto.Expression;
import ru.basedomains.dto.OrderEvent;
import ru.dispatcher.randomExpression.StartRandomExpression;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    private final NewTopic topic;

    private final KafkaTemplate<String, Expression> kafkaTemplate;

    private final StartRandomExpression startRandomExpression;

    @Scheduled(fixedDelay = 5000)
    public void method() {
        sendRandomNumber();
    }

    public void sendRandomNumber() {
        Expression expression = new Expression();
        String s = startRandomExpression.responseRandomExpression();
        expression.setExpression(s);
        sendMessage(expression);
        System.out.println(" send random number " + s);
    }

    public void sendMessage(Expression expression) {

        LOGGER.info(String.format("Order event => %s", expression.toString()));

        // create Message
        Message<Expression> message = MessageBuilder
                .withPayload(expression)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }

    public void sendMessage(OrderEvent event) {
        LOGGER.info(String.format("Order event => %s", event.toString()));

        // create Message
        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}