package main.HomeWorkLesson9;

public class Cat implements Participants{
    double jumpAbility;
    int runAbility;

    public Cat(double jumpAbility, int runAbility) {
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
