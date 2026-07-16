package practice;

public class Employees {
    /*Есть класс Employees, объявите в нем строковые переменные (name, role). Создайте 2 новых объекта
 класса (male, female), присвойте им имена (Александр, Наталья), Назначьте им должности
 соответственно (директор по маркетингу, заместитель директора по маркетингу) и верните строку,
 используя Переменные: Вчера наша компания пополнилась новыми сотрудниками. Александр нанят на
 должность Директора по маркетингу, а Наталья нанята в должности: заместитель директора по маркетингу.
 */
    private String name, role;

    private Employees(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public static void main(String[] args) {
        Employees male = new Employees("Александр", "директор по маркетингу");
        Employees female = new Employees("Наталья", "заместитель директора по маркетингу");
        String response = "Вчера наша компания пополнилась новыми сотрудниками. " + male.name + " нанят на"
                + " должность " + male.role + ", а " + female.name + " нанята в должности: " + female.role + ".";

        System.out.println(response);
    }
}
