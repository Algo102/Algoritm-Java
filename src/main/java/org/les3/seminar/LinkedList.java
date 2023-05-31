package org.les3.seminar;



//1.Реализуем простой односвязный список.
//2.Пишем только структуру, никаких методов не требуется.
// нажав ctrl и левую кн. мыши, можемпосмотреть где используется класс
public class LinkedList {

    private Node head;

    //Расширяем структуру связного списка до двухсвязного.
    private Node tail;

    private class Node{
        private Node next;
        private   int value;

        //Расширяем структуру связного списка до двухсвязного.
        private Node previous;
    }

    //Реализуем метод добавления новых элементов в начало списка и удаление
    //первого элемента связного списка.
    public void addFirst(int value){
        Node node = new Node();
        node.value = value;
        if(head != null)
            node.next = head;
        //Расширяем структуру связного списка до двухсвязного.
        else
            tail = node;
        node.previous = node;

        // Остается как для односвязного, так и для двусвязного
        head = node;
    }

    public void dellFirst(int value){
        if(head != null)
            head = head.next;
    }

    // Реализуем метод поиска элемента в односвязном списке для проверки
    // наличия элемента внутри списка.
    public Boolean findBool(int value){
        Node node = head;
        while (node.next != null){
            if (node.value == value)
                return true;
            node = node.next;
        }
        return false;
    }

    //Реализуем метод добавления новых элементов в конец списка.
    // Мне кажется раз есть previous то это двусвязный список
    public void addInEndList(int value){
        Node temp = head;
        while (head != null && temp.next != null)
            temp = temp.next;
        Node node = new Node();
        node.value = value;
        node.next = null;
        if(head != null)
            node.previous = temp;
        else
            head = temp;

        node.previous.next = node;
    }

    // удаление последнего элемента связного списка.
    public void delEndInList(){
        Node temp = head;
        if(temp != null){
            if(temp.next != null){
                while (temp.next.next != null)
                    temp = temp.next;
            }
            temp.next = null;
        }
        else
            head = null;
    }

    //Сортировка списка
    public void sort(){
        Node node = head;
        while (head != null && node.next != null){
            Node minPos = node;
            Node inner = node.next;
            while (inner != null){
                if(inner.value < minPos.value)
                    minPos = inner;
                inner = inner.next;
            }
            if(minPos != node){
                swap(node, minPos);

                if(minPos.previous == null)
                    head = minPos;
                if(minPos.next == null)
                    tail = minPos;
                node = minPos.next;
            }
            else
                node = node.next;
        }
    }

    private void swap(Node node1, Node node2){
        Node temp = node1.previous;
        node1.previous = node2.previous;
        node2.previous = temp;

        temp = node1.next;
        node1.next = node2.next;
        node2.next = temp;

        if(node1.previous != null)
            node1.previous.next = node1;

        if(node1.next != null)
            node1.next.previous = node1;

        if(node2.previous != null)
            node2.previous.next = node2;

        if(node2.next != null)
            node2.next.previous = node2;
    }
}
