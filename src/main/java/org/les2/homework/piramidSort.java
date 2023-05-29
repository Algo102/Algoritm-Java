package org.les2.homework;
import java.util.Random;

public class piramidSort {

    private static final Random random = new Random();

    public static void main(String[] args) {

        int[] unsorted = randomArray(10, 1, 10);

        printArray(unsorted);

        sort(unsorted);

        printArray(unsorted);

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

    public static void sort(int[] array){
        for (int i = array.length/2-1; i >= 0 ; i--)
            heapify(array, array.length, i);

        for (int i = array.length -1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            heapify(array,heapSize, largest);
        }
    }
}
