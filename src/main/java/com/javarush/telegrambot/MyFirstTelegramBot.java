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
        // шаг 1: отобразим начало игры - взломать холодильник
        if (getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step1pic");
            sendTextMessageAsync(TelegramBotContent.STEP_1_TEXT,Map.of("Взлом холодильника","button1"));
        }
        if(getCallbackQueryButtonKey().equals("button1")){
            addUserGlory(20);
            sendPhotoMessageAsync("step2pic");
            sendTextMessageAsync(TelegramBotContent.STEP_2_TEXT,
                    Map.of("Съесть сосиску! +25 к славе","button2",                            "Взять рыбку! +20 к славе","button3",
                            "Скинуть банку с огурцами! +20 к славе","button4"));        }
        // шаг 2: взломать робот-пылесос
        if (getCallbackQueryButtonKey().equals("button2")){
            addUserGlory(25);
            sendPhotoMessageAsync("step3pic");
            sendTextMessageAsync(TelegramBotContent.STEP_3_TEXT,Map.of("Взломать робот-пылесос! +15 к славе","button20"));        }
        if (getCallbackQueryButtonKey().equals("button3")){
            addUserGlory(20);
            sendPhotoMessageAsync("step3pic");
            sendTextMessageAsync(TelegramBotContent.STEP_3_TEXT,Map.of("Взломать робот-пылесос! +15 к славе","button20"));        }
        if (getCallbackQueryButtonKey().equals("button4")){
            addUserGlory(20);
            sendPhotoMessageAsync("step3pic");
            sendTextMessageAsync(TelegramBotContent.STEP_3_TEXT,Map.of("Взломать робот-пылесос! +15 к славе","button20"));        }
        if(getCallbackQueryButtonKey().equals("button20")){
            addUserGlory(20);
            sendPhotoMessageAsync("step4pic");
            sendTextMessageAsync(TelegramBotContent.STEP_4_TEXT,                    Map.of("Отправить робота за едой! +30 к славе","button41",
                            "Прокатиться на роботе! +10 к славе","button42",                            "Убежать! +5 к славе","button43"));
        }
        // шаг 3:  взламываем камеру Go-Pro
        if (getCallbackQueryButtonKey().equals("button41")){
            addUserGlory(30);
            sendPhotoMessageAsync("step5pic");
            sendTextMessageAsync(TelegramBotContent.STEP_5_TEXT,Map.of("Взломать Go-Pro","button50"));
        }
        if (getCallbackQueryButtonKey().equals("button42")){
            addUserGlory(10);
            sendPhotoMessageAsync("step5pic");
            sendTextMessageAsync(TelegramBotContent.STEP_5_TEXT,Map.of("Взломать Go-Pro","button50"));
        }        if (getCallbackQueryButtonKey().equals("button43")){
            addUserGlory(5);
            sendPhotoMessageAsync("step5pic");
            sendTextMessageAsync(TelegramBotContent.STEP_5_TEXT,Map.of("Взломать Go-Pro","button50"));
        }

        if(getCallbackQueryButtonKey().equals("button50")){
            sendPhotoMessageAsync("step6pic");
            sendTextMessageAsync(TelegramBotContent.STEP_6_TEXT, Map.of("Надеть Go-Pro! и тайно включить +40 к славе","button60"));
        }

        // шаг 4: взламываем компьютер
        if(getCallbackQueryButtonKey().equals("button60")){
            sendPhotoMessageAsync("step7pic");
            sendTextMessageAsync(TelegramBotContent.STEP_7_TEXT, Map.of("Взломать компьютер! +50 к славе","button70"));
        }
        // шаг 5: идем хвастаться другим котам
        if(getCallbackQueryButtonKey().equals("button70")){
            sendPhotoMessageAsync("step8pic");
            sendTextMessageAsync(TelegramBotContent.STEP_8_TEXT,Map.of("Ураа-а-а-а!","/stop"));
        }
        if(getCallbackQueryButtonKey().equals("/stop")){
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(TelegramBotContent.FINAL_TEXT);
        }


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