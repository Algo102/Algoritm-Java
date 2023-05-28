package org.les2.lecture;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]
                {4, 7, 2, 5, 8, 1, 9, 1, 2, 3, 6};

        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int startPosition, int endPosition){
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2];

        do{
            while (array[leftPosition] < pivot)
                leftPosition++;
            while (array[rightPosition] > pivot)
                rightPosition--;
            if(leftPosition <= rightPosition){
                if(leftPosition < rightPosition){
                    int temp = array[leftPosition];
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);
        if (leftPosition < endPosition)
            sort(array,leftPosition,endPosition);
        if (startPosition < rightPosition)
            sort(array, startPosition, rightPosition);
    }
}
