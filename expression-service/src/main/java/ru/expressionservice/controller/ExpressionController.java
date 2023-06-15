package ru.expressionservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.basedomains.dto.Expression;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpressionController {

    @GetMapping(path = "/expression")
    public ResponseEntity<Expression> request(@RequestBody Expression s) {
        System.out.println(s.getExpression());
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PostMapping(path = "/expression")
    public String createFoodOrder(@RequestBody Expression expression) throws JsonProcessingException {
        log.info("create expression request received");
//        return expressionService.createExpression(expression);
        return null;
    }

}
