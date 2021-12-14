package main.HomeWorkLesson6;

public class Main {
    public static void main(String[] args) {


        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Animal dogBarbos = new Dog("Барбос");
        Animal catBarsik = new Cat("Барсик");


        dogBobik.run(100);
        dogBobik.run(600);
        dogBobik.swim(10);
        dogBobik.swim(20);

        catMurzik.run(100);
        catMurzik.run(600);
        catMurzik.swim(10);
        System.out.println();

        System.out.printf("Общее количество животных: %d, из них котов: %d, собак: %d%n", Animal.getCountOfAnimals(), Cat.getCountOfCats(), Dog.getCountOfDogs());
    }


}
