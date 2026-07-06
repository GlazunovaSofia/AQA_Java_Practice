package practice;

public class OddNumbers {
    //  Задание 5.
    //  Пропуск четных
    //  Вывести только нечетные числа от 1 до 100 через continue.

    public static void main(String[] args){
        for (int i = 0; i <= 100; i++) {
            if(i%2 == 0){
                continue;
            }
            System.out.println(i);
        }
    }
}
