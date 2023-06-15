package ru.expressionservice.kafka_producer_expression;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.basedomains.dto.Expression;
import ru.expressionservice.service.ExpressionService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerExpression {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerExpression.class);

    private final NewTopic topic;

    private final KafkaTemplate<String, Expression> kafkaTemplate;

    private final ExpressionService expressionService;

    @Scheduled(fixedDelay = 5000)
    public void sendRandomNumber() {
        boolean allowNonTransactional = kafkaTemplate.isAllowNonTransactional();

        Expression expression = new Expression();
        String s = expressionService.sendRandomExpression();
        expression.setExpression(s);
        sendMessage(expression);
    }

    public void sendMessage(Expression expression) {
        LOGGER.info(String.format("Expression event => %s ", expression.toString()));

        Message<Expression> message = MessageBuilder
                .withPayload(expression)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}