package org.les3.homework;
// ДВУХСВЯЗНЫЙ СПИСОК
public class ReversDvusvList {
    Node head;
    Node tail;

    public  class Node{
        Node next;
        Node previous;
    }

    // Разворот для двухсвязанного списка
    public void reversDvusvSpis(){
        Node node = head;

        while (node != null){
            Node next = node.next;
            Node previous = node.previous;
            node.next = previous;
            node.previous = next;

            if(previous == null)
                tail = node;

            if(next == null)
                head = node;

            node = next;
        }
    }
}
