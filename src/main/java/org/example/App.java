package org.example;

import java.util.Scanner;

public class App {
    static int x;
    static int y;
    static Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public App() {
    }

    public double test(int a, int b) {
        double result = 0.0;
        // Проверка на возможность извлечения квадратного корня из отрицательного числа
        if (a < 0 || b < 0) {
            result = Double.NaN; // возвращаем NaN, если одно из чисел отрицательное
        } else { result = Math.sqrt((double)(a * b));}
        return result;
    }
    public int getX() {
        System.out.println("Введите x:");
        Scanner scan1 = new Scanner(System.in);
        int num = scan1.nextInt();
        int rez;
        if (num <= 100 && num > 0) {
            rez = num;
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуй-те еще раз.");
            rez = this.getX();
        }
        return rez;
    }
    public int getY() {
        System.out.println("Введите y:");
        Scanner scan2 = new Scanner(System.in);
        int num = scan2.nextInt();
        int rez;
        if (num <= 100 && num >= 0) {
            rez = num;
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуй-те еще раз.");
            rez = this.getY();
        }
        return rez;
    }
    public void printRez(int x, int y) {
        System.out.println("Результат вычисления равен " + this.test(x, y));
    }

    public static void main(String[] args) {
        App app = new App();
        x = app.getX();
        y = app.getY();
        app.printRez(x, y);
        System.console().readLine();
    }


}

