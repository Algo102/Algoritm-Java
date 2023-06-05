package org.les4.lecture;
// Красно черное дерево - Сложность O(log n), высокая производительность
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedBlackTree {

    public static void main(String[] args){
        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                }
                catch (Exception ignored){

                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Node root; // элемент с которого начинаем работать

    public boolean add(int value){
        // Если рутовая нода уже существует
        if (root !=null){
            // то мы создаем новую ноду относительно рута
            boolean result = addNode(root,value);
            // и обязательно балансируем сам рут
            root = rebalnce(root);
            // и ставим рут черным цветом
            root.color = Color.BLACK;
            return result;
        }
        else {
            // если рута нет, то создаем рут и даем ей черный цвет
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }

    }

    // Приватный метод который добавляет новый Нод
    // Возвращет булеевые значения, т.к. в бинарном дереве, все значения
    // должны быть уникальными и если нода с этим значением уже есть,
    // то новую с таким значением создать нельзя и метод скажет, удалось
    // ли создать новую ноду или возник конфликт
    private boolean addNode(Node node, int value){
        if(node.value == value) // Если такая Нода есть
            return false; // То создать нельзя
        else {
            if (node.value > value){ // Если искомая нода, болььше чем значение
                if(node.leftChild != null){ // при этом если левый ребенок существует
                    // То запускаем поиск рекурсивом по левому ребенку обходом в
                    // глубину, с проверкой, можно ли создать ноду там
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalnce(node.leftChild);
                    return result; // Если можно, то вернет результат
                }
                else { // Если же левой ноды не существует
                    // Считаем что нашли подходящее место для постановки значения, генерируем
                    // Ноду и присваиваем красны цвет. Для такого дерева, все ноды при
                    // создании получают красный цвет
                    node.leftChild = new Node();
                    node.leftChild.color = Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            }
            else { // для правого ребенка все аналогично
                // если он есть, запускаем рекурсивный обход в глубину
                if (node.rightChild != null){
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalnce(node.rightChild);
                    return  result;
                }
                else { // если его нет то генерируем значение
                    node.rightChild = new Node();
                    node.rightChild.color = Color.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    // Ребалансировка может выполняться несколько раз, например после
    // перемещения красной ноды с права на лево, а после левостороннего
    // поворота мы получим перемещение левого ребенка на правое место,
    // но красная нода станет правым ребенком, что не допустимо
    // левостороннему красно черному дереву. Поэтому правый поворот будет
    // совмещаться со свайпом цвета. Это несколько действий подряд, пока
    // не поймем, что ребалансиовка не нужна
    private  Node rebalnce(Node node){
        Node result = node;
        boolean needRebalance;
        do{
            needRebalance = false;
            // если есть правый ребенок с красным цветом и левый ребенок с черным цветом
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)){
                needRebalance = true;
                // производим правый поворот
                result = rightSwap(result);
            }
            // если есть левый ребенок и ее цвет красный, при этом у левого ребенка есть
            // свой левый ребенок и у него тоже красный цвет
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                needRebalance = true;
                // то выполняем левый поворот и разделяем левого ребенка от его же левого ребенка
                result = leftSwap(result);
            }
            // если и левый и правый ребенок имеют красный цвет
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.rightChild != null && result.rightChild.color == Color.RED) {
                needRebalance = true;
                // выполняем свайп цвета
                colorSwap(result);
            }
        }
        // как только мы понимаюем, что условия выше не исполняются, то
        // выходим из цикла и возвращаем результат
        while (needRebalance);
        return result;
    }

    // Для правостороннего поворота происходит аналогичная ситуация как и с
    // левосторонним поворотом, только относительно правого ребенка
    private  Node rightSwap(Node node){
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = Color.RED;
        return rightChild;
    }

    // Левосторнний перевод
    private  Node leftSwap(Node node){
        // Берем левостороннего ребенка и для удобства выделяем его в переменную
        Node leftChild = node.leftChild;
        // Берем промежуточного ребенка, так как родители будут меняться местами
        Node betweenChild = leftChild.rightChild;
        // Т.к. левосторонний поворот, то левосторонняя нода в оприории красная,
        // соответственно вместо правого ребенка красной ноды, назначаем рутовый
        // элемент с которого начали, т.е. текущего родителя
        leftChild.rightChild = node;
        // у родителя левым элементом становится не красная нода, а промежуточный
        // ребенок, согласно бинарному дереву, который имеет значение между красной
        // нодой и рутовой нодой
        node.leftChild = betweenChild;
        // Левый ребенок получает цвет своего родителя
        leftChild.color = node.color;
        // А корень, который отпустился ниже, становится красным
        node.color = Color.RED;
        return leftChild;

    }

    // при ребалансирвке происходит смена цвета, когда у Ноды два красных ребенка
    // Если нужно поменять цвет для указанной Ноды, мы берем ее детей, левого и правого
    // присваиваем им черные цвета, а сама нода становится красной
    private void colorSwap(Node node){
        node.rightChild.color = Color.BLACK;
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    private class  Node {
        private int value; // значение которе храним в узле
        private Color color; // Для работы красно-черного дерева есть признак -
        // цвет. Может быть черным или красны, что заводится благодоря enum
        private Node leftChild; // его левый ребенок
        private Node rightChild; // его правый ребенок

        @Override
        public String toString(){
            return "Node{" +
                    "value=" + value +
                    ", color=" + color +
                    '}';
        }
    }

    private enum Color{
        RED, BLACK
    }
}
