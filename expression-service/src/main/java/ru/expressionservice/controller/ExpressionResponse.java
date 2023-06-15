//package ru.dispatcher.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.bots.TelegramLongPollingBot;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Update;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import ru.dispatcher.randomExpression.StartRandomExpression;
//
//@Component
//@RequiredArgsConstructor
//public class ExpressionResponse extends TelegramLongPollingBot {
//
//    private final StartRandomExpression startRandomExpression;
//
//    @Value("${bot.name}")
//    private String botName;
//
//    @Value("${bot.token}")
//    private String botToken;
//
//    @Override
//    public String getBotUsername() {
//        return botName;
//    }
//
//    @Override
//    public String getBotToken() {
//        return botToken;
//    }
//
//    @SneakyThrows
//    @Override
//    public void onUpdateReceived(Update update) {
//        var msg = update.getMessage();
//        String text = msg.getText();
//        System.out.println("message from telegram - expressions = " + text);
//
////
////        while (true) {
////            String randomExpression = startRandomExpression.responseRandomExpression();
////
////            if (randomExpression.equals("75*75"))
////                System.err.println(" error " + randomExpression);
////
////            var response = new SendMessage();
////            response.setChatId(msg.getChatId().toString());
////            response.setText(randomExpression);
////            sendAnswerMessage(response);
////
////            Thread.sleep(3000);
////        }
//    }
//
//    public void sendAnswerMessage(SendMessage msg) {
//        if (msg != null) {
//            try {
//                execute(msg);
//            } catch (TelegramApiException e) {
//                System.out.println(e);
////                log.error(e);
//            }
//        }
//    }
//}
