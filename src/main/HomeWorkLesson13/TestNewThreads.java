package main.HomeWorkLesson13;

public class TestNewThreads {
    public static void main(String[] args) {

        fillByOne();
        fillByHalf();

    }
    private static void fillByOne () {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println ("Время выполнения без потоков составляет: " + (System.currentTimeMillis() - a) + " мс");
    }
    private static void fillByHalf () {
        int size = 10000000;
        int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h - 1; i++) {
                    arr1[i] = (float) (arr[i] * Math.sin (0.2f + i / 5) * Math.cos (0.2f + i / 5) * Math.cos (0.4f + i / 2));
                }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h - 1; i++) {
                arr2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println ("Время выполнения c потоками составляет: " + (System.currentTimeMillis() - a) + " мс");
    }
}
