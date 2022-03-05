package main.HomeWorkLesson4;

import java.util.Scanner;

public class TicTocToe {
    private static final int SIZE = 5;
    private static final String EMPTY_SIGN = "•";
    private static final String PC_SIGN = "○";
    private static final String HUMAN_SIGN = "X";
    private static final Scanner ROW = new Scanner(System.in);
    public static int inputRow;
    public static int inputCol;
    private static final String[][] array = new String[SIZE][SIZE];

    private static int countOfSignsHorizontal = 0;
    private static int countOfSignsVertical = 0;
    private static int countOfSignsHeadDiagonal = 0;
    private static int countOfSignsSideDiagonal = 0;

    public static void playGame() {
        initGame();
        do {
            stepByHuman();
            if (isWinByGamer(inputRow, inputCol)) {
                break;
            }
            printArr(array);
            if (checkingIsDraw()) {
                break;

            }
            stepByPC();
            if (isWinByPC(inputRow, inputCol)) {
                break;
            }
            printArr(array);
            if (checkingIsDraw()) {
                break;
            }
        } while (true);
        endOfGame();
    }

    private static String[][] getNewArray() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                array[i][j] = EMPTY_SIGN;
            }
        }
        return array;
    }

    private static void initGame() {
        printArr(getNewArray());
    }

    private static void printArr(String[][] arr) {//Метод для удобочитаемого вида вывода двумерного массива с учетом нумерации сверху и сбоку
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" ");
            System.out.print(i + 1);
        }
        System.out.println();
        for (int j = 0; j < SIZE; j++) {
            System.out.print(" ");
            System.out.print(j + 1 + " ");
            for (int k = 0; k < SIZE; k++) {
                System.out.print(arr[j][k] + " ");
            }
            System.out.println();
        }
    }

    private static void stepByHuman() {
        do {
            System.out.println("Ваш ход! Укажите строку и столбец");
            inputRow = ROW.nextInt() - 1;
            inputCol = ROW.nextInt() - 1;
        } while (!validateInput(inputRow, inputCol));
        array[inputRow][inputCol] = HUMAN_SIGN;
    }

    private static boolean validateInput(int numRow, int numCol) {//Метод проверки хода на соответствие требованиям
        if (numRow > SIZE || numRow < 0 || numCol > SIZE || numCol < 0) {
            System.out.println("Номера строки и столбца должны быть от 1 до " + SIZE);
            return false;
        }
            if (!array[numRow][numCol].equals(EMPTY_SIGN)){
                System.out.println("Ячейка, расположенная на " + (numRow + 1) + "-й строке и " + (numCol + 1) + "-м столбце уже занята");
                return false;
            } else {
                return true;
            }
        }

    private static void stepByPC() {
        do {
            inputRow = (int) (Math.random() * SIZE);
            inputCol = (int) (Math.random() * SIZE);
        } while (!validateInput(inputRow, inputCol));
        System.out.println("Компьютер пошел в ячейку: " + (inputRow + 1) + " -я строка, " + (inputCol + 1) + "-й столбец!");
        array[inputRow][inputCol] = PC_SIGN;
    }

    private static boolean checkingIsDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (array[i][j].equals(EMPTY_SIGN)) return false;
            }
        }
        System.out.println("Игра завершена в ничью");
            return true;
    }

    private static boolean isWinByGamer(int row, int col) {

        /*Проверяем количество крестиков по горизонтали*/
        countOfSignsHorizontal = 0;
        countOfSignsVertical = 0;
        /* Проверка количества знаков по горизонтали*/
        for (int i = 0; i < SIZE; i++) {
            if (array[row][i].equals(HUMAN_SIGN)) {
                countOfSignsHorizontal++;
                if (countOfSignsHorizontal >= 3) {
                    System.out.println("Выиграл человек");
                    return true;
                }
            } else {
                    countOfSignsHorizontal = 0;
                }
            }
        /* Проверка количества знаков по вертикали*/
        for (int i = 0; i < SIZE; i++) {
            if (array[i][col].equals(HUMAN_SIGN)) {
                countOfSignsVertical++;
                if (countOfSignsVertical >= 3) {
                    System.out.println("Выиграл человек");
                    return true;
                }
            } else {
                countOfSignsVertical = 0;
            }
        }

        /* Проверка количества знаков по диагоналям*/

        /* Проверяем количество крестиков по главной диагонали
        (если ход был на ячейке на главной диагонали) */
        if (row == col) {
        for (int x = 0; x < array.length; x++) {//для главной диагонали
            if (array[x][x].equals(HUMAN_SIGN)) {
                countOfSignsHeadDiagonal++;
                if (countOfSignsHeadDiagonal >= 3) {
                    System.out.println("Выиграл человек");
                    return true;
                }
            } else {
                countOfSignsHeadDiagonal = 0;
            }
        }
    }

        /* Проверяем количество крестиков ниже главной диагонали
        (если ход был на ячейке ниже главной диагонали) */
        countOfSignsHeadDiagonal = 0;
        if (row > col) {
            for (int x = row - col; x <= array.length - 1; x++) {//для главной диагонали
                if (array[x][x - (row - col)].equals(HUMAN_SIGN)) {
                    countOfSignsHeadDiagonal++;
                    if (countOfSignsHeadDiagonal >= 3) {
                        System.out.println("Выиграл человек");
                        return true;
                    }
                } else {
                    countOfSignsHeadDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков выше главной диагонали
        (если ход был на ячейке выше главной диагонали) */
        if (row < col) {
            for (int x = 0; x < array.length - col + row; x++) {
                if (array[x][x + col - row].equals(HUMAN_SIGN)) {
                    countOfSignsHeadDiagonal++;
                    if (countOfSignsHeadDiagonal >= 3) {
                        System.out.println("Выиграл человек");
                        return true;
                    }
                } else {
                    countOfSignsHeadDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков по побочной диагонали
        (если ход был на ячейке на побочной диагонали) */

        if (row == array.length - 1 - col) {
            for (int x = array.length - 1; x >=0; x--) {
                if (array[x][(array.length - 1) - x].equals(HUMAN_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл человек");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков выше побочной диагонали
       (если ход был на ячейке выше побочной диагонали) */
        if (row + col < array.length - 1) {
            for (int x = row + col; x >= 0; x--) {
                if (array[x][row + col - x].equals(HUMAN_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл человек");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }
//
//        /* Проверяем количество крестиков ниже побочной диагонали
//       (если ход был на ячейке ниже побочной диагонали) */
        if (row + col > array.length - 1) {
            for (int x = array.length - 1; x > row + col - array.length; x--) {
                if (array[x][row + col - x].equals(HUMAN_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл человек");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }
        return false;
    }

    private static boolean isWinByPC(int row, int col) {

        /*Проверяем количество крестиков по горизонтали*/
        for (int i = 0; i < SIZE; i++) {
            if (array[row][i].equals(PC_SIGN)) {
                countOfSignsHorizontal++;
                if (countOfSignsHorizontal >= 3) {
                    System.out.println("Выиграл компьютер");
                    return true;
                }
            } else {
                countOfSignsHorizontal = 0;
            }
        }
        /* Проверка количества знаков по вертикали*/
        for (int i = 0; i < SIZE; i++) {
            if (array[i][col].equals(PC_SIGN)) {
                countOfSignsVertical++;
                if (countOfSignsVertical >= 3) {
                    System.out.println("Выиграл компьютер");
                    return true;
                }
            } else {
                countOfSignsVertical = 0;
            }
        }

        /* Проверка количества знаков по диагоналям*/

        /* Проверяем количество крестиков по главной диагонали
        (если ход был на ячейке на главной диагонали) */
        if (row == col) {
            for (int x = 0; x < array.length; x++) {//для главной диагонали
                if (array[x][x].equals(PC_SIGN)) {
                    countOfSignsHeadDiagonal++;
                    if (countOfSignsHeadDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsHeadDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков ниже главной диагонали
        (если ход был на ячейке ниже главной диагонали) */
        countOfSignsHeadDiagonal = 0;
        if (row > col) {
            for (int x = row - col; x <= array.length - 1; x++) {//для главной диагонали
                if (array[x][x - (row - col)].equals(PC_SIGN)) {
                    countOfSignsHeadDiagonal++;
                    if (countOfSignsHeadDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsHeadDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков выше главной диагонали
        (если ход был на ячейке выше главной диагонали) */
        if (row < col) {
            for (int x = 0; x < array.length - col + row; x++) {
                if (array[x][x + col - row].equals(PC_SIGN)) {
                    countOfSignsHeadDiagonal++;
                    if (countOfSignsHeadDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsHeadDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков по побочной диагонали
        (если ход был на ячейке на побочной диагонали) */

        if (row == array.length - 1 - col) {
            for (int x = array.length - 1; x >=0; x--) {
                if (array[x][(array.length - 1) - x].equals(PC_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }

        /* Проверяем количество крестиков выше побочной диагонали
       (если ход был на ячейке выше побочной диагонали) */
        if (row + col < array.length - 1) {
            for (int x = row + col; x >= 0; x--) {
                if (array[x][row + col - x].equals(PC_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }
//
//        /* Проверяем количество крестиков ниже побочной диагонали
//       (если ход был на ячейке ниже побочной диагонали) */
        if (row + col > array.length - 1) {
            for (int x = array.length - 1; x > row + col - array.length; x--) {
                if (array[x][row + col - x].equals(PC_SIGN)) {
                    countOfSignsSideDiagonal++;
                    if (countOfSignsSideDiagonal >= 3) {
                        System.out.println("Выиграл компьютер");
                        return true;
                    }
                } else {
                    countOfSignsSideDiagonal = 0;
                }
            }
        }
        return false;
    }

//    private static boolean isPlayAnotherGame() {
////        System.out.println("Желаете продолжить? yes/no");
////        return switch (ROW.next()) {
////            case "yes", "Yes", "Да", "да" -> true;
////            default -> false;
////        };
//    }

    private static void endOfGame() {
        ROW.close();
        System.out.println("Игра завершена!");
    }

}
