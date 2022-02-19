package main.HomeWorkLesson9;

public class Main {
    public static void main(String[] args) {
        Human human = new Human(2.4, 20500);
        Participants cat = new Cat(1.8, 8000);
        Participants robot = new Robot(3.7, 20000);
        Treadmill treadmill = new Treadmill(10000);
        Wall wall = new Wall(2);
        Participants [] participants = {human, cat, robot};
        participants[0] = human;
        participants[1] = cat;
        participants[2] = robot;

        Obstacles[] obstacles = {treadmill, wall};

        for (Participants p: participants) {
            for (Obstacles o: obstacles) {
                o.passObstacle(p);
            }
        }
    }
}
