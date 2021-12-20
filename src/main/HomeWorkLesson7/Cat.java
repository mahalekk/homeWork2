package main.HomeWorkLesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }


}