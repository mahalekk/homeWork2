package main.HomeWorkLesson9;

public class Wall implements Obstacles {
    double height;
    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void passObstacle(Participants p) {
        if (p.jumpAbility < this.height) {
            System.out.println("Мдаа, далеко не Джордан! Так высоко прыгать не умеет");
            return;
        }
        System.out.println("Ура! Участник дошел до финиша");
    }
}
