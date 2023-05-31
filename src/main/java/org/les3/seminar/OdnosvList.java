package org.les3.seminar;

import java.util.Random;
public class OdnosvList {

    private static final Random random = new Random();


    public static void main(String[] args){
        // подтянули класс из соседнего файла
       LinkedList newList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            //после . показывает классы которые можно использовать
            newList.addInEndList(random.nextInt(0, 100));
        }

    }

    public static int[] randomArray(int size, int smallest, int largest){
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
           result[i] = random.nextInt(smallest, largest);
        }
        return result;
    }
}
