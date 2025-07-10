Небольшой телеграмм-бот в формате простой игры с картинками. 
Разработано при прохождении занятия от ДжаваРаш. 
Токен телеграмм-бота сокрыт в классе SecurityNote и не выгружен в репозиторий. 


public class SecurityNote {
    private static final String NAME = "Имя бота"; // TODO: добавьте имя бота в кавычках
    private static final String TOKEN = "Ваш токен"; //TODO: добавьте токен бота в кавычках

    public static String getNAME() {
        return NAME;
    }

    public static String getTOKEN() {
        return TOKEN;
    }
}  Класс помещаем в основной пакет с другими классами. 
