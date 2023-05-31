package org.les3.homework;
//   РАЗВОРОТ В ОДНОСВЯЗНОМ СПИСКЕ
public class ReversOdnLists {
    Node head;

    public  class Node{
        Node next;
    }

// Упростим функцию перевызовом. Так же нужно учитывать, если нет элементов
//или он один, то разворачивать нечего
    public void reversOdnosvSpis(){
        if(head != null && head.next != null) {
            Node temp = head;
            reversOdnosvSpis(head.next, head);
            temp.next = null;
        }
    }

// Разворот в односвязном списке происходит с помощью рекурсии, так как есть
// ссылка только на следующий элемент
    public void reversOdnosvSpis(Node node, Node previous){
        if(node.next == null)
            head = node;
        else
            reversOdnosvSpis(node.next, node);
        node.next = previous;
    }
}
