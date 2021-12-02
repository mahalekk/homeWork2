package main.HomeWorkLesson2;

public class HomeWorkLesson2 {
    public static void main(String[] args) {
        
        System.out.println("Проверка метода isSumIncluded со следующими числами 5 и 4; 5 и 6; 11 и 20; 11 и 9");

        System.out.println(isSumIncluded(5,4));
        System.out.println(isSumIncluded(5,6));
        System.out.println(isSumIncluded(11,20));
        System.out.println(isSumIncluded(11,9));
        System.out.println();

        System.out.println("Проверка метода isNumPositive со следующими числами 5 , -10, 0");
        isNumPositive(5);
        isNumPositive(-10);
        isNumPositive(0);
        System.out.println();

        System.out.println("Проверка метода isNumPositive со следующими числами 5 , -10, 0");
        System.out.println(isNumPositiveBoolean(5));
        System.out.println(isNumPositiveBoolean(-10));
        System.out.println(isNumPositiveBoolean(0));
        System.out.println();

        System.out.println("Проверка метода printStringsFewTimes со следующими аргументами 'Строка для печати' и 10");
        printStringsFewTimes("Строка для печати", 10);
        System.out.println();

        System.out.println("Проверка метода isYearLeap со следующими аргументами 1600,  2200,  1996, 2002");
        System.out.println(isYearLeap(1600));
        System.out.println(isYearLeap(2200));
        System.out.println(isYearLeap(1996));
        System.out.println(isYearLeap(2002));

    }
    private static boolean isSumIncluded(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;}
    }

    private static void isNumPositive(int a) {

        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");}
    }

    private static boolean isNumPositiveBoolean(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;}
    }

    private static void printStringsFewTimes(String s, int times) {
        for (int i = 1; i <= times; i++) {
            System.out.println(s + " напечатана " + i + "-й раз");
        }
    }
    private static boolean isYearLeap(int year) {
        if (year % 4 == 0 & year % 100 !=0)  {
            return true;
        } else if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else if (year % 100 == 0 && year % 400 == 0) {
            return true;
        }
        else  { return false;}
    }
}
