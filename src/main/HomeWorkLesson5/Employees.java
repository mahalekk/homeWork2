package main.HomeWorkLesson5;

public class Employees {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Employees(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public String toString(){
        return String.format("Сотрудник %s, должность: %s, email: %s, номер телефона: %s, заработная плата: %d, возраст: %d", name, position, email, phoneNumber, salary, age);
    }

    public void printInfo() {
        System.out.println(this);
    }

}
