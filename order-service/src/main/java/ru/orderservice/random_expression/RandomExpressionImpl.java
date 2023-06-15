package ru.orderservice.random_expression;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RandomExpressionImpl implements StartRandomExpression {

    public static int randomNumber() {
        var min = 0;
        var max = 100;
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static String randomExpression() {
        List<Character> characterList = List.of('+', '-', '*', '/');
        var one = randomNumber();
        var two = randomNumber();
        char charOperation = characterList.get((int) (Math.random() * (characterList.size() - 1) + 1));
        return convertExpressionToString(one, two, charOperation);
    }

    private static String convertExpressionToString(int one, int two, char charOperation) {
        return String.valueOf(one) + charOperation + two;
    }

    @Override
    public String responseRandomExpression() {
        return randomExpression();
    }
}
