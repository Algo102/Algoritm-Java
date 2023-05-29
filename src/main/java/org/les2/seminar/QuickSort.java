package org.les2.seminar;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class QuickSort {

    private static final Random random = new Random();

    public static void main(String[] args){

//        int[] unsorted = randomArray(20, 10, 100);
//        printArray(unsorted);
//        sort(unsorted);
//        printArray(unsorted);
        for (int i = 10_000; i < 1_000_000 ; i+=10_000) {
            int[] unsorted = randomArray(i, 10, 100);
            Date startDate = new Date();
            sort(unsorted.clone()); //чтоб не создавать новый массив, копируем есго под вычисление
            Date endDate = new Date();
            long duration = endDate.getTime() - startDate.getTime();
            System.out.printf("From matrix QUICK is %d elements, time: %d ms", i, duration);
            System.out.println();

            Date startDate2 = new Date();
            bubbleSort(unsorted.clone()); //чтоб не создавать новый массив, копируем есго под вычисление
            Date endDate2 = new Date();
            long duration2 = endDate2.getTime() - startDate2.getTime();
            System.out.printf("From matrix BUBBLE is %d elements, time: %d ms", i, duration2);
            System.out.println();

            Date startDate3 = new Date();
            Arrays.sort(unsorted.clone()); //системная сортировка
            Date endDate3 = new Date();
            long duration3 = endDate3.getTime() - startDate3.getTime();
            System.out.printf("From matrix SYSTEM is %d elements, time: %d ms", i, duration3);
            System.out.println();
        }
        
    }

    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    /** - java doc - помогает посмотреть параметры у метода
     *
     * @param array не отсортированный массив
     * @param startPos позиция начала
     * @param endPos позиция конца
     */
    public static void sort(int[] array, int startPos, int endPos){
        int leftPos = startPos;
        int rightPos = endPos;
        int pivot = array[(startPos + endPos) / 2];

        do{
            while (array[leftPos] < pivot)
                leftPos++;
            while (array[rightPos] > pivot)
                rightPos--;
            if(leftPos <= rightPos){
                if(leftPos < rightPos){
                    int temp = array[leftPos];
                    array[leftPos] = array[rightPos];
                    array[rightPos] = temp;
                }
                leftPos++;
                rightPos--;
            }
        } while (leftPos <= rightPos);
        if (leftPos < endPos)
            sort(array,leftPos,endPos);
        if (startPos < rightPos)
            sort(array, startPos, rightPos);
    }

    public static int[] bubbleSort(int[] unsorted){
        for (int i = 0; i < unsorted.length-1; i++) {
            for (int j = 0; j < unsorted.length-1-i; j++) {
                if (unsorted[j] > unsorted[j+1]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j+1];
                    unsorted[j+1] = temp;
                }
            }
        }
        return unsorted;
    }
    public static int[] randomArray(int size, int smallest, int largest){
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(smallest, largest);
        }
        return result;
    }

    public static void printArray(int[] toPrint){
        for (int element: toPrint) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }
}
