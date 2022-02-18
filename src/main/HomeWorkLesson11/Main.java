package main.HomeWorkLesson11;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Пункт 1 задания
        ArrayList<String> arrayList = new ArrayList<> (20);
        arrayList.add ("Tom");
        arrayList.add ("Smith");
        arrayList.add ("Jerry");
        arrayList.add ("Buddy");
        arrayList.add ("Elena");
        arrayList.add ("Mark");
        arrayList.add ("Tom");
        arrayList.add ("Krit");
        arrayList.add ("Apollo");
        arrayList.add ("Ali");
        arrayList.add ("Mark");
        arrayList.add ("Elena");
        arrayList.add ("Tom");
        arrayList.add ("Paul");
        arrayList.add ("Tom");
        HashSet<String> uniqueSet = new HashSet<> ();
        uniqueSet.addAll (arrayList);
        System.out.println (uniqueSet);
        for (String element : uniqueSet) {
            long count = arrayList.stream ().filter (element::equals).count ();
            if (count == 2 || count == 3 || count == 4) {
                System.out.println ("Имя " + element + " встречается в списке " + count + " раза");
            } else System.out.println ("Имя " + element + " встречается в списке " + count + " раз");
        }
        // Пункт 2 задания
        HashMap<String, String> phoneDictionary = new HashMap<> ();
        add(phoneDictionary);
        get(phoneDictionary, "Иванов");

    }
        private static void add (HashMap<String,String> map) {
            int[] array = new int[20];
            for (int j = 0; j < 20; j++) {
                int random = (int) (Math.random () * 100000000 + 1);
                array[j] = random;
            }
            System.out.println (Arrays.toString (array));
            map.put (String.valueOf (array[0]), "Иванов");
            map.put (String.valueOf (array[1]), "Сергеич");
            map.put (String.valueOf (array[2]), "Плашев");
            map.put (String.valueOf (array[3]), "Иванов");
            map.put (String.valueOf (array[4]), "Петров");
            map.put (String.valueOf (array[5]), "Зюзев");
            map.put (String.valueOf (array[6]), "Иванов");
            map.put (String.valueOf (array[7]), "Авакумов");
            map.put (String.valueOf (array[8]), "Иванов");
            map.put (String.valueOf (array[9]), "Матич");
            map.put (String.valueOf (array[10]), "Иванов");
            map.put (String.valueOf (array[11]), "Петров");
            map.put (String.valueOf (array[12]), "Сидоров");
            map.put (String.valueOf (array[13]), "Чичиков");
            map.put (String.valueOf (array[14]), "Иванов");
            map.put (String.valueOf (array[15]), "Сеткин");
            map.put (String.valueOf (array[16]), "Немцов");
            map.put (String.valueOf (array[17]), "Жириновский");
            map.put (String.valueOf (array[18]), "Лопата");
            map.put (String.valueOf (array[19]), "Иванов");
            System.out.println (map);
            }
        private static void get (HashMap<String,String> map, String name) {
                Set<String> keys = new HashSet<>();
                for (Map.Entry<String, String> found : map.entrySet()) {
                    if (name.equals (found.getValue ())) {
                        keys.add(found.getKey());
                    }
                }
            System.out.println (keys);
            }
}
