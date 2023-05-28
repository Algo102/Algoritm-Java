package org.les2.lecture;

public class Find {

    public static void main(String[] args){

        int[] array = new int[]
                {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(find(array, 5));
        System.out.println(binarySearch(array, 5));
// Для проверки работоспособности, обычно вводят крайние элементы
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 9));
        System.out.println(binarySearch(array, 99));

    }
// Обычным поиск перебором
// Так как используем 1 цикл for, то сложность будет O(n)
    public static  int find(int[] array, int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1; //Если ни чего не найдено, то -1, пишем воизбежание ошибки
    }

// Перегружаем функцию с бинарным поиском, чтоб вместе вызова не писать
// полноценную функцию, со всеми аргументами
    public static  int binarySearch(int[] array, int value){
        return (binarySearch(array, value, 0, array.length-1));
    }

// Бинарный поиск, поиск осуществляется в нужной половине массива, работает
// только с отсортированным массивом.Сложность O(lg n)
    public static  int binarySearch(int[] array, int value, int min, int max){
        int midpoint;

        if (max < min)
            return -1;
        else
            midpoint = (max - min) / 2 + min;

        if (array[midpoint] < value)
            return binarySearch(array, value, midpoint+1, max);
        else {
            if (array[midpoint] > value)
                return binarySearch(array, value, min,midpoint-1);
            else
                return midpoint;
        }
    }
}
