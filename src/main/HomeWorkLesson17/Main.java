package main.HomeWorkLesson17;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String [] array = new String[]{"abc", "def"};
        Number [] nums = new Number[]{34, 4, 34545, 8455778, 1235678};


        TestObject<String> stringTestObjectA = new TestObject<> ();
        TestObject<String> stringTestObjectB = new TestObject<> ();
        TestObject<String> stringTestObjectC = new TestObject<> ();
        TestObject<String> stringTestObjectD = new TestObject<> ();
        TestObject[] testObjects = new TestObject[]{stringTestObjectA, stringTestObjectB, stringTestObjectC, stringTestObjectD};
        replaceElements (0,1, array);
        replaceElements (2,3, nums);
        System.out.println (Arrays.toString (testObjects));
        replaceElements (1,2, testObjects);


        convertToArrayList(array);
        convertToArrayList(nums);
        convertToArrayList(testObjects);


        Apple apple = new Apple ();
        Fruit<Orange> orange = new Orange ();


        Box box1 = new Box ();
        Box box2 = new Box ();
        Box box3 = new Box ();

        box1.putIntoBox (apple, 159);
        box1.putIntoBox (apple, 143);
        box1.putIntoBox (apple, 121);

        box2.putIntoBox (orange, 23);
        box2.putIntoBox (orange, 47);
        box2.putIntoBox (orange, 61);

        box3.putIntoBox (apple, 1);
        box3.putIntoBox (apple, 4);
        box3.putIntoBox (apple, 5);


        System.out.println (String.format ("В первой коробке %d единиц фруктов %s",box1.getCountFruits (), box1.getFruitType()));
        System.out.println (String.format ("Во второй коробке %d единиц фруктов %s",box2.getCountFruits (), box2.getFruitType()));
        System.out.println (String.format ("В третьей коробке %d единиц фруктов %s",box3.getCountFruits (), box3.getFruitType()));

        System.out.printf ("Вес первой коробки составляет %.2f единиц %n",box1.getWeight ());
        System.out.printf ("Вес второй коробки составляет %.2f единиц %n",box2.getWeight ());
        System.out.printf ("Вес третьей коробки составляет %.2f единиц %n",box2.getWeight ());

        box1.compareBoxes (box2);

        box3.restoreBoxes (box1);

        System.out.println (String.format ("В первой коробке после пересыпания %d единиц фруктов %s",box1.getCountFruits (), box1.getFruitType()));
        System.out.println (String.format ("В третьей коробке после пересыпания %d единиц фруктов %s",box3.getCountFruits (), box3.getFruitType()));
        System.out.printf ("Вес первой коробки после пересыпания составляет %.2f единиц %n",box1.getWeight ());



    }
    private static <T> void replaceElements(int a, int b, T[] array) throws IndexOutOfBoundsException {
            T temp;
            temp = array[a];
            array[a] = array[b];
            array[b] = temp;
        System.out.println (Arrays.toString (array));
    }

    private static <T> void convertToArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<> (Arrays.asList (array));
        System.out.println (list);
    }


}
