package org.les2.lecture;

public class HeapSort {

    public static void main(String[] args) {

        int[] array = new int[]
                {4, 7, 2, 5, 8, 1, 9, 1, 2, 3, 6};

        sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }



    public static void sort(int[] array){
        //построение кучи (перегруппируем массив)
        for (int i = array.length/2-1; i >= 0 ; i--)
            heapify(array, array.length, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = array.length -1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            //Вызываем heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; //инициализируем наибольший элемент как корень
        int leftChild = 2 * rootIndex +1;
        int rightChild = 2 + rootIndex + 2;

        //Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[rightChild] > array[largest])
            largest = leftChild;

        //Если правый доч. элемент больше, чем самый большой элемент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;

        //Если самый большой элемен не корень
        if(largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            //Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(array,heapSize, largest);
        }
    }


}
