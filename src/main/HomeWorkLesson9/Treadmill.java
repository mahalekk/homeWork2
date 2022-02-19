package main.HomeWorkLesson9;

import java.util.spi.AbstractResourceBundleProvider;

public class Treadmill implements Obstacles {
  int length;

  public Treadmill(int length) {
    this.length = length;
  }
  void printLength() {
    System.out.println("Длина пути составляет " + this.length);
  }

  public int getLength() {
    return length;
  }

  @Override
  public void passObstacle(Participants p) {
    System.out.println(this.getLength() < p.getRunAbility() ? "Ура! Участник дошел до финиша" : "Участник не добежал! Сошел с дистанции");
  }

}

