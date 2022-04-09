package main.HomeWorkLesson20;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        GetLetters getLetters = new GetLetters ();
        //буква А
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                getLetters.getLetterA ();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //буква B
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                getLetters.getLetterB ();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //буква C
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                getLetters.getLetterC ();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        fillByOne();
        fillByHalf();

    }
    private static void fillByOne () {
        int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill (arr, 1.0f);
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println ("Время выполнения без потоков составляет: " + (System.currentTimeMillis() - a) + " мс");
    }
    private static void fillByHalf () {
        long a = System.currentTimeMillis();
        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill (arr, 1.0f);


        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < h - 1; i++) {
            int j=i;
            pool.execute (() -> {
                arr1[j] = (float) (arr[j] * Math.sin (0.2f + j / 5) * Math.cos (0.2f + j / 5) * Math.cos (0.4f + j / 2));
                try {
                    Thread.sleep (100);
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            });
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println ("Время выполнения c потоками составляет: " + (System.currentTimeMillis() - a) + " мс");
    }
}
