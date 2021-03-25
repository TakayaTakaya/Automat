package Automats;

import java.util.Scanner;

public class MyAutomat {
    private static int state = 0;
    private static int[] comand = new int[]{1, 2, 3, 4};
    private static int[] status = new int[]{0, 1, 2, 3, 4, 5, 6};
    private static final int ERROR = -1;
    private static int code = 123;
    private static int balance = 1000;
    static Scanner sc = new Scanner(System.in);
    static int COUNTER = 0;

    public static void main(String[] args) {
        next(state);
    }

    public static void getState(int x) {
        next(status[x]);
    }

    public static int next(int x) {
        switch (state) {
            case 0:
                System.out.println("Введите пароль: ");
                int pass = sc.nextInt();
                if (pass == code) state = 1;
                else {
                    System.out.println("Неверный пароль!");
                    COUNTER++;
                    System.out.println("Осталось попыток: " + (3 - COUNTER));
                    if (COUNTER < 3) {
                        next(state);
                        break;
                    } else state = 5;
                    getState(state);
                    break;
                }
            case 1:
                System.out.println("Выберите услугу:" + "\n" + "Чтобы <Внести наличные>, введите 1" + "\n" + "Чтобы <Напечатать чек>, введите 2" + "\n" + "Чтобы <Вывести наличные>, введите 3" + "\n" + "Чтобы <Вернуть карту>, введите 4");
                int input = sc.nextInt();
                if (input == comand[0]) {
                    System.out.println("Вставьте купюры по одному!");
                    state = 2;
                    getState(state);
                    break;
                }
                if (input == comand[1]) {
                    state = 3;
                    getState(state);
                    break;
                }
                if (input == comand[2]) {
                    state = 4;
                    getState(state);
                    break;
                }
                if (input == comand[3]) {
                    state = 5;
                    getState(state);
                    break;
                } else {
                    System.out.println("Введена неверная команда!");
                    state = 1;
                    getState(state);
                    break;
                }
            case 2:
                int plusSum = sc.nextInt();
                if (plusSum > 0) {
                    balance = balance + plusSum;
                    state = 2;
                    getState(state);
                    break;
                }
                if (plusSum == 0) {
                    state = 6;
                    getState(state);
                    break;
                }
            case 3:
                System.out.println("Ваш баланс: " + balance + " руб.");
                state = 6;
                getState(state);
                break;
            case 4:
                System.out.println("Какую сумму желаете снять?");
                int minusSum = sc.nextInt();
                if (balance - minusSum > 0) {
                    balance = balance - minusSum;
                    state = 3;
                    getState(state);
                    break;
                } else {
                    System.out.println("Недостаточно средств! Введите другое значение.");
                    state = 1;
                    getState(state);
                    break;

                }
            case 5:
                System.out.println("Завершение работы. Благодарим за использование наших сервисов!");
                break;
            case 6:
                System.out.println("Хотите завершить работу, 1 - да, 2 - нет.");
                int act = sc.nextInt();
                if (act == comand[1]) {
                    state = 1;
                    getState(state);
                    break;
                }
                if (act == comand[0]) {
                    state = 5;
                    getState(state);
                    break;
                }else {
                    System.out.println("Введена неверная команда!");
                    state = 6;
                    getState(state);
                    break;
                }
        }
        return ERROR;
    }
}
