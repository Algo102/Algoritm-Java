

package org.les1.seminar;

public class task1 {
    public static void main(String[] args) {
        //Необходимо написать алгоритм, считающий сумму всех чисел
//        от 1 до N. Согласно свойствам линейной сложности,
//        количество итераций цикла будет линейно изменяться
//        относительно изменения размера N.
        int number = 12;
        int total = 0;
        for (int i = 0; i <= number ; i++) {
            total += i;
        }
        System.out.println("Total - " + total);

        // другой вариант
        int total2 = (number * (number + 1)) / 2;
        System.out.println("Total2 - " + total2);
    }
}