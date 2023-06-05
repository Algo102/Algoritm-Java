package org.les4.seminar;


public class MainHT {

    public static void main(String[] args) {
        HashTable<Integer, Integer> hashTable = new HashTable<>();
        Basket basket = new Basket();



        Entity entity = new Entity();
        basket.add(entity, hashTable.basketArray);

    }
}
