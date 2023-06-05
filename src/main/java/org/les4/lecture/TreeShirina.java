package org.les4.lecture;
import java.util.ArrayList;
import java.util.List;
// Обход в ширину, это когда после рута проверяем сначала детей, потом на
// уровень ниже детей этих детей и т.д.
// Применяются циклы, а не рекурсия, поэтому можно обрабатывать оочень большие деревья
// Чаще всего применяется, для того чтобы отобразить все элементы одной иерархии
// возможно нужно отрисовать дерево, по линиям это гораздо проще
// но это занимает больше памяти чем обход в глубину, так как нужно сохранять
// ссылки на все ноды и детей
public class TreeShirina {
    Node root; // Базовое поле, является началом, откуда дерево начинает расти

    public class Node{
        // В дерево можно положить значения любого типа, для облегчения
        // понимания, будем работать с цифрами
        int value; // некое значение
        List<Node> children; // список его детей
        // В основном дерево обходят от корня root, но бывают и частные случаи,
        // поэтому для базового дерева иметь ссылку на его родителя не требуется

    }

 // Обход в ширину, применяются циклы
    private Node find(int value){
        List<Node> line = new ArrayList<>(); // Заводим список
        line.add(root); // в currentline добавляем root, т.к. мы начинаем работать с него
        while (line.size() > 0){ // пробегаем циклом, пока есть какие-то дети
            List<Node> nextLine = new ArrayList<>(); //Завели новый список
            for (Node node : line){ // Перебираем линию для каждого элемента
                if (node.value == value) // Если node.value == value
                    return  node; // то возвращаем Ноду
                nextLine.addAll(node.children); // если этого не происходит,
                // то в nextLine добавляем всех его детей
            }
            // если мы прошли по всем линиям и у нас нет ни каких вхождений и мы
            // ни разу не вызвали return
            line = nextLine;
        }
        return  null;

    }


}