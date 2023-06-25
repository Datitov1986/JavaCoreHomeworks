import java.util.Scanner;

/**
 * Класс с полями сканнер для считывания информации, введенной пользователем.
 * Этот класс исполняет основные методы
 *
 */
public class FirstClass {
    Scanner scanner;

    public FirstClass() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Метод запуска, принимающий данные из метода setData
     * и проверяющий в верном ли формате введен возраст
     */

    public void run() {
        String name = setData("Введите имя: ");
        String age_str = setData("Введите возраст: ");
        int age = 0;
        try {
            age = Integer.parseInt(age_str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Decorator.helloUser(name, age);
    }

    /**
     * Метод, принимающий данные от пользователя
     * @param msg сообщение для пользователя
     * @return возвращает сканнер
     */

    public String setData(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }
}
