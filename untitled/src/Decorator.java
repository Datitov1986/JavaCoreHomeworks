/**
 * Класс декоратор, выводит сообщение с ответом
 */
public class Decorator {
    /**
     * Метод приветствия пользователя
     * @param name имя пользователя, введенное в терминале
     * @param age возраст пользователя, введенный в терминале
     */
    public static void helloUser(String name, int age) {
        System.out.println("Здравствуйте, " + name + "! Ваш возраст: " + age);
    }
}
