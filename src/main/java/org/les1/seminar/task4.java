package org.les1.seminar;

// Разбираем рекурсию. Ответ 4 3 2 1 1 2 2

// так как здесь рекурсия, то сложность экспотенциальная

public class task4 {
    public static void main(String[] args) {
        f(4);


    }

    static void f(int n) {
        System.out.print(" " + n);
        if (n >=3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }
}
