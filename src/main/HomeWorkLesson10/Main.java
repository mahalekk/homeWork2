package main.HomeWorkLesson10;

import java.lang.reflect.Type;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] inputArray = {{"5454", "1212", "5343", "3678"}, {"5641", "5678", "3413", "4352"}, {"3975", "3941", "3394", "2342"}, {"8345", "6564", "6546", "2321"}};
        System.out.println ("Сумма элементов массива равна: " + checkArray (inputArray));
    }

    private static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkArraySize (array);
        printArr (checkElements (array));
        int sum = getSum (checkElements (array));
        return sum;
    }

    private static int[][] checkElements(String[][] array) {
        int[][] outputArray = new int[4][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i][j] == "") {
                    throw new MyArrayDataException ("Имеются пустой элемент массива в " + (i + 1) + "-й строке и в " + (j + 1) + "-м столбце!");
                }
                try {
                    outputArray[i][j] = Integer.parseInt (array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("Внимание имеется некорректные данные в " + (i + 1) + "-й строке и в " + (j + 1) + "-м столбце!");
                }
            }
        }
        return outputArray;
    }

    private static void checkArraySize(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i].length != 4) || array.length != 4) {
                throw new MyArraySizeException ("Размер массива не корректен");
            }
        }
    }

    private static int getSum(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum = sum + array[i][j];
            }

        }
        return sum;
    }

    private static void printArr(int[][] arr) {//Метод для удобочитаемого вида вывода двумерного массива
        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print (ints[j] + "  ");
            }
            System.out.println ();
        }
    }
}

