package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;


public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Flamehelp_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "1126645206:AAETgoTfnIVkJfISK149b1Xm44VXbHM4oGI"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {


    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}

/*   // TODO: основной функционал бота будем писать здесь
        //final String userName=updateEvent.getMessage().getFrom().getUserName();
        //final String userFirstNameVar=updateEvent.getMessage().getFrom().getFirstName();
        if(getMessageText().equals("/start")){
        sendTextMessageAsync(String.format("Привет, будущий программист %s (@%s)",
                updateEvent.getMessage().getFrom().getFirstName(), updateEvent.getMessage().getFrom().getUserName()));
        }*/
/* ПРАКТИЧЕСКОЕ ЗАДАНИЕ №2 (до 17:00 завтрашнего дня)
            👉 Допиши диалог. Если пользователь ввел команду "/bye", выведи сообщение "Asta la vista, baby!"
            👉 Отобрази сообщение: "Ваше любимое животное?" с двумя кнопками: "Кот" и "Собака";
            👉 При нажатии пользователем кнопки "Кот", нужно вывести на экран картинку step_4_pic;
            👉 При нажатии пользователем кнопки "Собака", нужно вывести на экран картинку step_6_pic;
        Сдаешь задание прямо сюда, в этот бот.
        Формат сдачи задания: скриншот кода. */
/*
        if(getMessageText().contains("привет")){
                sendTextMessageAsync("Ваше любимое животное?",Map.of("Кот","cat1","Собака","dog1"));}
                if(getMessageText().contains("hi")){
                sendTextMessageAsync("Ваше любимое животное?",Map.of("Кот","cat1","Собака","dog1"));}
                if(getMessageText().contains("Привет")){
                sendTextMessageAsync("Ваше любимое животное?",Map.of("Кот","cat1","Собака","dog1"));}

                if(getCallbackQueryButtonKey().equals("cat1")){ sendPhotoMessageAsync( "step4pic");}
                if(getCallbackQueryButtonKey().equals("dog1")){ sendPhotoMessageAsync( "step6pic");}

                if (getMessageText().equals("/bye")){
                sendTextMessageAsync("Asta la vista, baby!");
                }

//sendTextMessageAsync("Первое сообщение в боте. Привет!");
//sendTextMessageAsync("Сразу _дополнительное_ сообщение с инфой о *чем-то*");
//sendTextMessageAsync("На сегодня все");
//sendTextMessageAsync(" что-то за сообщение ,"+ updateEvent.getMessage().getFrom().getUserName() + " where _" +updateEvent.getMessage().getFrom().getId());


//String message = updateEvent.getMessage().getText(); //считываем сообщение  принцип эхо.
//sendTextMessageAsync(message);

//sendTextMessageAsync(TelegramBotContent.STEP_1_TEXT);
//sendPhotoMessageAsync("step_1_pic");*/