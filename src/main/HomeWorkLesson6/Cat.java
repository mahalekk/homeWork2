package main.HomeWorkLesson6;

public class Cat extends Animal {
    public static int countOfCats;

    public Cat(String name) {
        super(name);
        countOfCats++;
    }

    public static int getCountOfCats() {
        return countOfCats;
    }

    @Override
    public void run (int length) {
        if (length <= 200) {
            System.out.println(this.getName() + " пробежал " + length + " метров");
        }
        else {
            System.out.println(this.getName() + " не может пробежать" + " больше 200 метров");
        }
    }
    @Override
    public void swim (int length) {
            System.out.println(this.getName() + " не умеет плавать!");
    }

}
