package src.main.HomeWorkLesson3;

import java.util.Arrays;

public class HomeWorkLesson3 {
    public static void main(String[] args) {

        int [] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};//Пункт 1 задания
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else {
                array1[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array1));//Проверка пункта 1 задания
        System.out.println();

        int[] array2 = new int[100];//Пункт 2 задания
        array2[0] = 1;
        for (int i = 0; i <array2.length - 1 ; i++) {
            array2[i + 1] = array2[i] + 1;
        }
        System.out.println(Arrays.toString(array2));//Проверка пункта 2 задания
        System.out.println();

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }; //Проверка пункта 3 задания
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array3));//Проверка пункта 2 задания
        System.out.println();

        //Пункт 4 задания

        //Создаем и заполняем двумерный массив размером 5 на 5 случайными целыми числами от 0 до 9
        int[][] array4 = new int[5][5];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++) {
                array4[i][j] = (int) (Math.random() * 10);
            }
        }

        printArr(array4);
        System.out.println();

        for (int i = 0; i < array4.length; i++) {//Цикл для замены элементов главной диагонали на 1
            for (int j = 0; j < array4.length; j++) {
                if(i == j) {
                    array4[i][j] = 1;
                }
            }
        }
        printArr(array4);//Проверка пункта 4 задания (замена элементов главной диагонали на 1)
        System.out.println();
        for (int i = array4.length - 1; i >= 0; i--) {//Цикл для замены элементов побочной диагонали на 1
            array4[i][(array4.length - 1) - i] = 1;
        }
        printArr(array4);//Проверка пункта 4 задания (замена элементов побочной диагонали на 1)
        System.out.println();

        //Пункт 5 задания
        System.out.println(Arrays.toString(returnArray(10, 5)));
        System.out.println();
        //Пункт 6 задания
        //Создаем и заполняем одномерный массив размером 10 случайными целыми числами от 0 до 100
        int[] array5 = new int[10];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = (int) (Math.random() * 101);
        }

        int min = 99;//Циклы нахождения максимального и минимального элемента
        int max = 0;
        for (int i = 0; i < array5.length; i++) {
            if (array5[i] < min) {
                min = array5[i];
            }
            if (array5[i] > max) {
                max = array5[i];
            }
        }
        System.out.println("Минимальный элемент в массиве " + Arrays.toString(array5) + " равен " + min);
        System.out.println("Максимальный элемент в массиве " + Arrays.toString(array5) + " равен " + max);
        System.out.println();

        //Пункт 7 задания
        int [] array6 = {2, 2, 2, 1, 2, 2, 10, 1};
        int [] array7 = {2, 2, 2, 6};
        int [] array8 = {8, 2, 2, 1, 2, 1};
        int [] array9 = {78, 2, 24, 101, 2, 1};

        System.out.println(returnIsSumOfLeftAndRightEqual(array6));
        System.out.println(returnIsSumOfLeftAndRightEqual(array7));
        System.out.println(returnIsSumOfLeftAndRightEqual(array8));
        System.out.println(returnIsSumOfLeftAndRightEqual(array9));
        System.out.println();

        //Пункт 8 задания
        int[] array10 = {3, 5, 6, 1};
        System.out.println(Arrays.toString(sliceIndexes(array6,4)));

    }
    public static void printArr(int[][] arr) {//Метод для удобочитаемого вида вывода двумерного массива
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + "  ");
            }
            System.out.println();
        }
    }

    public static int [] returnArray(int len, int initialValue) {//Метод согласно пункта 5 задания
        int [] returnArray = new int[len];
        for (int i = 0; i < len; i++) {
            returnArray[i] = initialValue;
        }
        return returnArray;
    }

    public static boolean returnIsSumOfLeftAndRightEqual(int [] array) {//Метод согласно пункта 7 задания
        int sumLeft = 0; //инициализация суммы левой части
        int sumRight;    //инициализация суммы правой части

        for (int i = 0; i < array.length; i++) { //запускаем цикл для суммы левой части
            sumLeft = sumLeft + array[i];
            sumRight = 0; //обнуляем сумму правой части при инкрементировании индекса левой части
            for (int j = array.length - 1; j > i ; j--) { //запускаем цикл для суммы правой части с конца и до i не включительно
                sumRight = sumRight + array[j];
                if (sumLeft == sumRight && (j - i) == 1) { //Проверка условия равенства сумм и нахождения левой и правой части рядом
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] sliceIndexes(int[] array, int n) {//Метод согласно задания 8 сдвиг влево
        for (int i = 0; i < n; i++) {//перебор по количеству символов сдвига
            int res = array[0];
            for (int j = 0; j < array.length - 1; j++) {//перебор по элементам массива
                array[j] = array[j + 1];
            }
            array[array.length - 1]= res;
        }
        return array;

    }
}
