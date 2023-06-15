package ru.expressionservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.expressionservice.random_expression.StartRandomExpression;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpressionServiceImpl implements ExpressionService {

    private final StartRandomExpression startRandomExpression;

    @Override
    public String sendRandomExpression() {
        return startRandomExpression.responseRandomExpression();
    }
}