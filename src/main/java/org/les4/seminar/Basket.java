package org.les4.seminar;

public class Basket{

    public Node head;

    public void add(javax.swing.text.html.parser.Entity entity, Basket[] basketArray) {
    }

    private class Node{
        private Entity value;
        private Node next;
    }

    //1. Необходимо реализовать методы добавления элементов в связный
    //список, если там еще нет пары с аналогичным ключом и удаления
    //элемента с аналогичным ключом из списка.
    //2. Все значения ключей в хэш-таблице уникальны, а значит и в каждом из
    //связных список это правило будет также выполняться.
    public Boolean add(Entity entity, Basket[] basketArray){
        if(basketArray[calculateIndex(entity.getKey(), basketArray)] != null){
            return false;
        }
        Basket.Node current = head;
        Node node = new Node();
        node.value = entity;
        while (current.next != null)
            current = current.next;
        current.next = node;
        return true;
    }

    //1. Реализуем метод поиска данных по ключу в хэш-таблице.
    //2. Теперь, когда у нас есть базовая структура нашей хэш-таблицы, можно
    //написать алгоритм поиска элементов, включающий в себя поиск нужного
    //бакета и поиск по бакету.
    private Integer calculateIndex(Object key, Basket[] basketArray){
        return key.hashCode() % basketArray.length;
    }

    private Object get(Object key, Basket[] basketArray){
        if(basketArray[calculateIndex(key, basketArray)] != null){
            return basketArray[calculateIndex(key, basketArray)];
        }
        return null;
    }
}
