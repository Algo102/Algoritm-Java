package org.les3.lecture;
// ДВУХСВЯЗНЫЙ СПИСОК
public class List2svyazn {
    Node head; // Лист содержит ссылку на первую позицию для односвязного списка
    Node tail; // Ссылка на последний элемент, в двухсвязном списке

    //Метод для добавления элемента в конец связного списка
    public void add(int value){
        Node node = new Node();
        node.value = value;
        // Определяем, есть ли у него еще елементы или эта первая Нода
        // Если нет, то новая Нода становится и головой и хвостом
        if (head == null){
            head = node;
            tail = node;
        }
        else {
            // Иначе новая Нода становится хвостом, а бывший хвост становится предидущим
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    // Метод вставки в середину списка. Добавляем значение после какой-то Ноды
    // Размер списка не важен, нужно только иметь ссылку, куда хотим добавить
    // Так как нет индексов в связанном списке и ничего не нужно двигать при
    // вставке элемента, то Сложность будет O(1), в отличие от массива O(n)
    public void add(int value, Node node){
        Node next = node.next; // это то на что ссылается Нода на данный момент
        Node newNode = new Node(); // Опять сгенерируем Ноду
        newNode.value = value; // Обновляем значение в новой Ноде
        node.next = newNode; // берем текущую Ноду и говорим, что следующее значение это ее новая Нода
        newNode.previous = node; // а ньюНоде говорим, что ее предыдущее значение, на текущий момент Нода

        // Нужно обновить tail, так как мы получили новую Ноду
        if (next == null) {
            tail = newNode;
        }
        else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    // Функция удаления Нода, принимает в себя искомую Ноду
    public void delete(Node node){
        Node previous = node.previous; // новые переменные
        Node next = node.next; //Которые находятся до и после искомого Нода

        // Если искомая Нода на позиции головы
        // Если предидущая Нода равна 0, то есть искомая оказалась голова
        if (previous == null){
            next.previous = null; // удаляем первый элемент
            head = next; // и говорим что началом станет следующий
        }
        else {
            // Если элемент в конце списка равен 0
            if(next == null){
                previous.next = null; // удалили последний элемент
                tail = previous; // поставили указатель на хвост
            }
            else {
                // Обработаем ситуацию когда Нода находится в середине
                // Тем самым удаляем искомую Ноду
                previous.next = next;
                next.previous = previous;
            }
        }
    }


    // Метод который будет искать значения в списке
    // Так как тут нет индексов, нужно перебирать. Сложность O(n)
    public Node find(int value){
        Node currentNode = head; // Переменная которая начинается с головы
        while (currentNode != null){
            // Если равно нашему искомому, то возвращаем
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next; // если этого не произошло, то переходим к следующему по списку
        }
        return null; // Если прошлись по всем Node и ничего не нашли, то возвращаем null
    }


    // Разворот для двухсвязанного списка
    public void revert(){
        Node currentNode = head;
        // Проходим по списку пока не упремся в 0
        while ((currentNode != null)){
            Node next = currentNode.next; //Используем ссылки на следующую и
            Node previous = currentNode.previous;//предыдущую, записанные в Ноде
            currentNode.next = previous; // Меняем их местами
            currentNode.previous = next;

            // Если предпоследни 0, то он будет хвостом
            if(previous == null)
                tail = currentNode;

            // Если последний элемент 0, то он будет первым
            if(next == null)
                head = currentNode;

            // Переходим к следующиму элементу, пока все не поменяем
            currentNode = next;
        }
    }

    public  class Node{
        int value; // Можно хранить любые переменные
        Node next; // Делеаем ссылку на следующий Node для организации односвязного списка

        Node previous; // Делаем ссылку, чтоб мы могли обращаться к предыдущему значению
    }
}
