package main.HomeWorkLesson5;

public class Main {
    public static void main(String[] args) {
        Employees[] employees = new Employees[5];

        employees[0] = new Employees("Larisa Dolina", "CEO", "l.dolina@employees.com", "+79161214525", 1500000, 65);
        employees[1] = new Employees("Michail Vdovychenko", "deputy director", "m.vdovychenko@employees.com", "+79161214537", 1300000, 38);
        employees[2] = new Employees("Egor Kridov", "PR-manager", "e.kridov@employees.com", "+79161215896", 520000, 35);
        employees[3] = new Employees("Anfisa Chekhova", "office manager", "a.chekhova@employees.com", "+79161245878", 200000, 45);
        employees[4] = new Employees("Pamela Andersen", "secretary", "p.andersen@employees.com", "+79178521400", 150000, 58);

        employees[0].printInfo();
        System.out.println();

        for (Employees employee : employees) {
            if (employee.getAge() > 40) employee.printInfo();
        }
    }
}
