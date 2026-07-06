package practice;

import com.github.javafaker.Faker;

import java.util.Scanner;

public class Lottery {
    //  Задание 6. Лотерея
    //  Пользователь вводит свое имя через Scanner.
    //  Faker генерирует случайное имя победителя.
    //  Программа сравнивает:
    //  Ваше имя: Анна
    //  Победитель: Мария

    //   Вы не выиграли
    //           или
    //   Поздравляем! Вы выиграли!

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Пожалуйста, введите свое имя...");
        String realName = scanner.nextLine();
        Faker faker = new Faker();
        String winName = faker.name().firstName();
        boolean isWin = isWin(realName, winName);
        String result = result(isWin);

        System.out.println(result);
    }

    public static boolean isWin(String realName, String winName) {
        return realName.equalsIgnoreCase(winName);
    }

    public static String result(boolean isWin) {
        if(!isWin) {
            return "Вы не выиграли";
        }
        else return "Поздравляем! Вы выиграли!";
    }
}
