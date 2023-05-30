package org.les3.lecture;
// Очередь FIFO, с хвоста заходит, с головы выходит
// Преимущество, что такие списки работают за
// константную скорость и могут динамически
// расширяться и сужаться, как с начала так и с конца
public class FIFO {
    Node head;
    Node tail;

    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    // Для извлечения последнего элемента из очереди
    public Integer peek(){
        Integer result = null;
        if(tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }

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
        Node previous;
    }
}
