package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "Flamehelp_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "1126645206:AAFZXs4XpIsX_AGbc_ywV2DBJO2llUwC3qw"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        // TODO: основной функционал бота будем писать здесь
        sendTextMessageAsync("Первое сообщение в боте. Привет!");
        sendTextMessageAsync("Сразу _дополнительное_ сообщение с инфой о *чем-то*");
        sendTextMessageAsync("На сегодня все");
       // sendTextMessageAsync(TelegramBotContent.STEP_1_TEXT);
        //sendPhotoMessageAsync("step_1_pic");

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}