package main.HomeWorkLesson20;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FillArrays {

    public static void fillByOne() {
        int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill (arr, 1.0f);
        long a = System.currentTimeMillis ();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));
        }
        System.out.println ("Время выполнения без потоков составляет: " + (System.currentTimeMillis () - a) + " мс");
    }

    public static void fillByHalf() {
        long a = System.currentTimeMillis ();
        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];
        Arrays.fill (arr, 1.0f);
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy (arr, 0, arr1, 0, h);
        System.arraycopy (arr, h, arr2, 0, h);
        ExecutorService pool = Executors.newFixedThreadPool (2);

        pool.execute (() -> {
            for (int i = 0; i < h; i++) {
                arr1[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));
                arr2[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));

            }
        });
        try {
            Thread.sleep (500);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        pool.shutdown();
        System.arraycopy (arr1, 0, arr, 0, h);
        System.arraycopy (arr2, 0, arr, h, h);
//        System.out.println ("arr" + Arrays.toString (arr));
        System.out.println ("Время выполнения c потоками составляет: " + (System.currentTimeMillis () - a) + " мс");
    }
}
