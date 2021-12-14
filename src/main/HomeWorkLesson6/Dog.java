package main.HomeWorkLesson6;

public class Dog extends Animal{
    public static int countOfDogs;

    public Dog(String name) {
        super(name);
        countOfDogs++;

    }

    public static int getCountOfDogs() {
        return countOfDogs;
    }

    @Override
    public void run (int length) {
        if (length <= 500) {
            System.out.println(this.getName() + " пробежал " + length + " метров");
        }
        else {
            System.out.println(this.getName() + " не может пробежать " + " больше 500 метров");
        }
    }

    @Override
    public void swim (int length) {
        if (length <= 10) {
            System.out.println(this.getName() + " проплыл " + length + " метров");
        }
        else {
            System.out.println(this.getName() + " не может проплыть " + " больше 10 метров");
        }
    }

}
