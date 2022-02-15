package main.HomeWorkLesson9;

public class Robot implements Participants {

    double jumpAbility;
    int runAbility;

    public Robot(double jumpAbility, int runAbility) {
        this.jumpAbility = jumpAbility;
        this.runAbility = runAbility;
    }

    public double getJumpAbility() {
        return jumpAbility;
    }

    public int getRunAbility() {
        return runAbility;
    }
}
