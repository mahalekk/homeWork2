package main.HomeWorkLesson7;

public class Main {
    public static void main(String[] args) {
        Cat Barsik = new Cat("Barsik", 15);
        Cat Adolf = new Cat("Adolf", 15);
        Cat Tom = new Cat("Tom", 20);
        Cat Nala = new Cat("Nala", 35);
        Cat Manya = new Cat("Manya", 10);
        Cat Lilu = new Cat("Lilu", 10);
        Cat Anfisa = new Cat("Anfisa", 40);

        Cat[] cat = new Cat[7];
        cat[0] = Barsik;
        cat[1] = Adolf;
        cat[2] = Tom;
        cat[3] = Nala;
        cat[4] = Manya;
        cat[5] = Lilu;
        cat[6] = Anfisa;


        Plate plate = new Plate(100);
        plate.info();
        for (int i = 0; i < cat.length; i++) {
            if (plate.getFood() == 0) {
                System.out.println("Еда закончилась");
            }
            if (cat[i].getAppetite() > plate.getFood()) {
                continue;
            } else {
                cat[i].eat(plate);
                cat[i].setSatiety(true);
            }
        }
        System.out.println();
        for (int i = 0; i < cat.length; i++) {
            if (cat[i].isSatiety()) {
                System.out.printf("Кот %s наелся%n", cat[i].getName());
            } else {
                System.out.printf("Кот %s остался голодным%n", cat[i].getName());
            }
        }
    }
}
