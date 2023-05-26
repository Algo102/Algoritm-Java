package org.les1.seminar;

// Пишем алгоритм поиска нужного числа последовательности
// Фибоначчи. Считаем, что 1 и 2 значения последовательности
// равны 1. Искать будем по формуле On=On-1+On-2 что

import java.util.Date;

public class task5 {
    public static void main(String[] args) {


    // так как здесь рекурсия, то сложность экспотенциальная О(2^n)
        Date start1 = new Date();
        System.out.println(fibExp(30));
        Date stop1 = new Date();
        System.out.println(stop1.getTime() - start1.getTime() + " msec");

    // Уже линейная зависимость О(n)
        Date start2 = new Date();
        fibLine(30);
        Date stop2 = new Date();
        System.out.println(stop2.getTime() - start2.getTime() + " msec");
    }
    // другое решение
    public static void fibLine(int num){

        int first = 1;
        int second = 1;

        for (int i = 2; i < num ; i++) {


            int third = first + second;
            first = second;
            second = third;
        }
        System.out.println(second);
    }

    public static int fibExp(int n){
        //System.out.println(n);
        if (n <= 2)
            return 1;
        else
            return fibExp(n-1) + fibExp (n-2);
    }
}
