package main.HomeWorkLesson17;

public interface Fruit<E> {

    double fruitWeight = 0;
    public default double getWeightFruit() {
        return this.fruitWeight;
    }
}
