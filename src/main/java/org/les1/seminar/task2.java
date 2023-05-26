package org.les1.seminar;

public class task2 {
    public static void main(String[] args) {
        //Написать алгоритм поиска простых чисел (делятся только на себя и на 1)
        // в диапазоне от 1 до N. В алгоритме будет использоваться вложенный
        // for, что явно говорит о квадратичной сложности
        int num = 10;
        for (int i = 1; i < num; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    flag = false;
            }
            if (flag)
                System.out.print(i + " ");
        }
    }
}