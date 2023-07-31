package HW;
/* Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент, который будет находиться на k-й позиции в конечном отсортированном массиве.

        Массив 1 - 100 112 256 349 770
        Массив 2 - 72 86 113 119 265 445 892
        к = 7
        Вывод : 256


        Окончательный отсортированный массив -
        72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
        7-й элемент этого массива равен 256 */


public class SortedArrays {
    public static void main(String[] args) {
        /* объявляем первый массив */
        int[] arr1 = {100, 112, 256, 349, 770};
        /* объявляем второй массив */
        int[] arr2 = {72, 86, 113, 119, 265, 445, 892};
        /* объявляем переменную типа integer, которая будет отражать позицию нужного
        * элемента в отсортированном массиве  */
        int k = 7;
        /* вызываем метод mergeArrays для объединения двух массивов и их сортировки */
        int[] sortedArray = mergeArrays(arr1, arr2);
            /* метод findKElement для поиска k-го элемента в объединенном и отсортированном массиве */
        System.out.println("K-ый элемент в отсортированном массиве " + findKElement(arr1, arr2, k));
        System.out.println("Отсортированный массив " + arrayToString(sortedArray));
    }

    /*  объявляется новый метод с именем findKElement,
    который принимает два массива и целое число в качестве параметров ввода и возвращает целое число */
    public static int findKElement(int[] arr1, int[] arr2, int k) {
        /*объявляем две переменные типа integer для хранения длины каждого массива*/
        int n = arr1.length;
        int m = arr2.length;

        if (n > m) {
            return findKElement(arr2, arr1, k);
        }
        /*  если один из массивов пуст   */
        if (n == 0) {
            return arr2[k - 1];
        }
        /*  если  k равно одному */
        if (k == 1) {
            return Math.min(arr1[0], arr2[0]);
        }
        /*  Объявляем индексы i и j для разделения каждого массива на две части */
        int i = Math.min(n, k / 2);
        int j = Math.min(m, k / 2);
        /* сравниваем средние элементы каждого массива и
        рекурсивно вызываем метод findKElement с обновленными параметрами */

        if (arr1[i - 1] > arr2[j - 1]) {
            return findKElement(arr1, subArray(arr2, j), k - j);
        } else {
            return findKElement(subArray(arr1, i), arr2, k - i);
        }
    }
    /* метод subArray принимает один массив и один целочисленный параметр в качестве входных данных
    и возвращает новый массив, который содержит элементы из оригинального массива,
    начиная с указанного индекса и заканчивая конечным индексом по умолчанию (который равен длине массива) */
    public static int[] subArray(int[] array, int start) {
        return subArray(array, start, array.length);
    }
    /* Второй метод subArray принимает два целочисленных параметра в качестве входных данных
    и возвращает новый массив, который содержит элементы из оригинального массива,
    начиная с первого индекса и заканчивая вторым индексом.
    Эти два метода используются в методе findKElement для разделения каждого массива на две части*/
    public static int[] subArray(int[] array, int start, int end) {
        int[] result = new int[end - start];
        for (int i = start; i < end; i++) {
            result[i - start] = array[i];
        }
        return result;
    }
    /* В этой строке объявляется новый метод с именем arrayToString,
   который принимает целочисленный массив в качестве входного параметра и возвращает строку.*/
    public static String arrayToString(int[] array) {
        /* создаем новый объект StringBuilder */
        StringBuilder sb = new StringBuilder();
        /* для каждого элемента массива array:
        добавляем элемент в объект StringBuilder
         добавляем пробел в в объект StringBuilder
         и преобразовываем объект StringBuilder в строку*/
        for (int i : array) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
    /* объединяет два отсортированных массива arr1 и arr2 */
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        /* создаем переменные n и m, которые равны длинам массивов arr1 и arr2 */
        int n = arr1.length;
        int m = arr2.length;
        /* создаем новый массив result, который имеет длину n + m */
        int[] result = new int[n + m];
        /* копируем элементы массива arr1 в начало массива result */
        for (int i = 0; i < n; i++) {
            result[i] = arr1[i];
        }
        /* копируем элементы массива arr2 в конец массива result  */
        for (int j = 0; j < m; j++) {
            result[n + j] = arr2[j];
        }
        /* сортируем массив result в порядке возрастания */
        for (int i = 0; i < n + m - 1; i++) {
            for (int j = i + 1; j < n + m; j++) {
                if (result[i] > result[j]) {
                    swap(result, i ,j);
                }
            }
        }
        /* возвращаем отсортированный массив */
        return result;
    }
     /* метод меняет местами элементы массива array с индексами aIndex и bIndex */
    public static void swap(int[] array, int aIndex, int bIndex) {
        /* создаем временную переменную temp и присваиваем ей значение элемента массива array с индексом aIndex.*/
        int temp = array[aIndex];
        /* присваиваем элементу массива array с индексом aIndex значение элемента массива array с индексом bIndex */
        array[aIndex] = array[bIndex];
        /* присваиваем элементу массива array с индексом bIndex значение временной переменной temp*/
        array[bIndex] = temp;
    }
}