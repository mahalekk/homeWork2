package main.HomeWorkLesson17;

import java.util.ArrayList;

public class Box {

    public String getFruitType() {
        return this.fruitType;
    }

    // Для проверки типа фруктов
    private String fruitType;

    // Для использования веса единицы
    private Fruit fruitObject;
    public ArrayList<Integer> boxStore = new ArrayList<> ();

    public <T> void putIntoBox(T fruit, int fruitCount) {
        String type = fruit.getClass ().getSimpleName ();
        this.fruitObject = (Fruit) fruit;
        if(this.boxStore.isEmpty () || (this.fruitType.equals (type))) {
            boxStore.add (fruitCount);
            this.fruitType = type;
        } else {
            throw new IllegalArgumentException ("Нельзя ложить разные фрукты в одну коробку");
        }
    }

    public double getWeight() {
        double boxWeight = 0.0f;
        for (Integer element : this.boxStore) {
            boxWeight = boxWeight + element * this.fruitObject.getWeightFruit ();
        }
        return boxWeight;
    }

    public int getCountFruits() {
        int countFruits = 0;
        for (int fruits: this.boxStore) {
            countFruits = countFruits + fruits;
        }
        return countFruits;
    }

    public void compareBoxes(Box box) {
        if (this.getWeight () > box.getWeight ()) {
            System.out.println ("Первая коробка тяжелее");
        } else System.out.println ("Первая коробка легче");
    }

    public void restoreBoxes(Box box) {
        if (this.fruitType.equals (box.fruitType)) {
            this.boxStore.addAll (box.boxStore);
            box.boxStore.removeAll (box.boxStore);
        } else {
            throw new IllegalArgumentException ("Нельзя пересыпать разные фрукты в одну коробку");
        }
    }
}
