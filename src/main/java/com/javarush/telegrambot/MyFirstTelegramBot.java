package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Base64;
import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;


public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = SecurityNote.getNAME(); // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = SecurityNote.getTOKEN(); //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            createMessageMyMetod("/start", 0, "step1pic", STEP_1_TEXT, Map.of("Взлом холодильника", "button1"));
        }
        if (!getCallbackQueryButtonKey().equals(null)) {
            tukTukSendMessage();
        }
        if (getCallbackQueryButtonKey().equals("/stop")) {
            setUserGlory(0);
            createMessageMyMetod("/stop", 0, "final_pic", FINAL_TEXT, Map.of("Финиш!", "/null"));
        }
        if (getMessageText().equals("/glory")) {
            int a = getUserGlory();
            sendTextMessageAsync("Текущий уровень славы:" + a);
        }

    }

    private void createMessageMyMetod(String buttonInput, int glories, String picName, String stepText, Map<String, String> buttons) {
        /*text - текст сообщенияж
          glories - кол-во славы
           picName - название картинки
            Map<String,String> buttons - кнопки
            */
        addUserGlory(glories);
        SendPhoto photoMessage = createPhotoMessage(picName);
        executeAsync(photoMessage);
        sendTextMessageAsync(stepText.replace("%s", String.valueOf(getUserGlory())), buttons);
    }

    private void tukTukSendMessage() {
        String text = getCallbackQueryButtonKey();
        switch (text) {

            case ("button1"):
                createMessageMyMetod("button1", 20, "step2pic", STEP_2_TEXT, Map.of("Съесть сосиску! +25 к славе", "button2",
                        "Взять рыбку! +20 к славе", "button3", "Скинуть банку с огурцами! +20 к славе", "button4"));                break;
            // шаг 2: взломать робот-пылесос
            case ("button2"):
                createMessageMyMetod("button2", 25, "step3pic", STEP_3_TEXT, Map.of("Взломать робот-пылесос! +15 к славе", "button20"));                break;
            case ("button3"):
                createMessageMyMetod("button3", 20, "step3pic", STEP_3_TEXT, Map.of("Взломать робот-пылесос! +15 к славе", "button20"));                break;
            case ("button4"):
                createMessageMyMetod("button4", 20, "step3pic", STEP_3_TEXT, Map.of("Взломать робот-пылесос! +15 к славе", "button20"));                break;
            case ("button20"):
                createMessageMyMetod("button20", 15, "step4pic", STEP_4_TEXT,
                        Map.of("Отправить робота за едой! +30 к славе", "button41", "Прокатиться на роботе! +10 к славе", "button42", "Убежать! +5 к славе", "button43"));
                break;
            // шаг 3:  взламываем камеру Go-Pro
            case ("button41"):
                createMessageMyMetod("button41", 30, "step5pic", STEP_5_TEXT, Map.of("Взломать Go-Pro", "button50"));                break;
            case ("button42"):
                createMessageMyMetod("button42", 10, "step5pic", STEP_5_TEXT, Map.of("Взломать Go-Pro", "button50"));                break;
            case ("button43"):
                createMessageMyMetod("button43", 5, "step5pic", STEP_5_TEXT, Map.of("Взломать Go-Pro", "button50"));                break;
            case ("button50"):
                createMessageMyMetod("button50", 25, "step6pic", STEP_6_TEXT, Map.of("Поснимать!", "button60"));                break;
            // шаг 4: взламываем компьютер
            case ("button60"):
                createMessageMyMetod("button60", 40, "step7pic", STEP_7_TEXT, Map.of("Взломать компьютер! +50 к славе", "button70"));                break;
            // шаг 5: идем хвастаться другим котам
            case ("button70"):
                createMessageMyMetod("button70", 50, "step8pic", STEP_8_TEXT, Map.of("Ураа-а-а-а!", "/stop"));                break;
            case ("/null"):sendTextMessageAsync("Ты прошел игру!");
            default:                ;                break;
        }

    }


    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());



        String encoded="SmF2YSDQvdC1INGC0L7RgNC80L7Qt9C40YIhCg==";
        try {
            // Здесь размещается ваш код кодирования или декодирования
         //   String decoded1 = new String(Base64.getDecoder().decode(encoded));
           // System.out.print(decoded1);

            byte[] decodedBytes = Base64.getDecoder().decode(encoded);
            String decodedString = new String(decodedBytes);
            System.out.println(decodedString);

        } catch(IllegalArgumentException e) {
            // Некорректный ввод для операций с Base64? О, не сегодня!
        }
    }
}