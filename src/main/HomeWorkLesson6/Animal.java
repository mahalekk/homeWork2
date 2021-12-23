package main.HomeWorkLesson6;

public abstract class Animal {
    private String name;
    public static int countOfAnimals;

    public Animal(String name) {
        this.name = name;
        countOfAnimals++; //счетчик объектов
    }

    public String getName() {
        return name;
    }

    public static int getCountOfAnimals() {
        return countOfAnimals;
    }

    protected abstract void run(int length);

    protected abstract void swim(int length);

}
