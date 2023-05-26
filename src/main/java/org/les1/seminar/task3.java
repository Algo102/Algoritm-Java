package org.les1.seminar;
//Необходимо написать алгоритм поиска всех доступных комбинаций (посчитать количество)
// для 4 кубиков с количеством граней N.
// Данное решение имеет сложность O(n4), но если количество кубиков сделать переменной,
// то она трансформируется в O(nk), что будет представлять собой экспоненциальную сложность.

public class task3 {

    // Другой вариант через функцию
    private static int countCube(int m) {
        int resalt = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        resalt++;
                    }
                }
            }
        }
        return resalt;
    }

    public static void main(String[] args) {
        int n = 6;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        count ++;
                    }
                }
            }
        }
        System.out.println(count);


        System.out.println(countCube(6));
    }
}
