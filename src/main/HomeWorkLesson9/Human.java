package main.HomeWorkLesson9;

public class Human implements Participants {

    double jumpAbility;
    int runAbility;

    public double getJumpAbility() {
        return jumpAbility;
    }

    public int getRunAbility() {
        return runAbility;
    }

    public Human(double jumpAbility, int runAbility) {
        this.jumpAbility = jumpAbility;
        this.runAbility = runAbility;
    }
}
