package org.les3.lecture;
// Частный случай связного списка
// Стек или LIFO, когда очередь уменьшается с конца, принцип стопки бумаг
public class StackLIFO {
    Node head;

    // Положить данные. В начало очереди
    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    //Извлечение данных, ничего не принимает, так как извлекает
    public Integer pop(){
        Integer result = null;
        if (head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

    public void revert(){
        if(head != null && head.next != null) {
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }

    public void revert(Node currentNode, Node previousNode){

        if(currentNode.next == null)
            head = currentNode;
        else
            revert(currentNode.next, currentNode);
        currentNode.next = previousNode;
    }

    public  class Node{
        int value;
        Node next;
    }
}
