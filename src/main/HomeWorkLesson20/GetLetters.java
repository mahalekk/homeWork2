package main.HomeWorkLesson20;

public class GetLetters {
    private char s = 'C';
    public synchronized void getLetterA() {
        if (s != 'C') {
            System.out.println("---Сработала блокировка по букве А");
            try {
                wait ();
                System.out.println("+++Снята блокировка по букве А");
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("---Выводится буква A");
        s = 'A';
        notifyAll ();
    }

    public synchronized void getLetterB() {
        if(s != 'A') {
            System.out.println("---Сработала блокировка по букве B");
            try {
                wait ();
                System.out.println("+++Снята блокировка по букве B");
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("---Выводится буква B");
        s = 'B';
        notifyAll ();
    }

    public synchronized void getLetterC() {
        if (s != 'B') {
            System.out.println("---Сработала блокировка по букве C");
            try {
                wait ();
                System.out.println("+++Снята блокировка по букве B");

            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
        System.out.println ("---Выводится буква C");
        s = 'C';
        notifyAll ();
    }

}
