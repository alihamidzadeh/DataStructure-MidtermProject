package Application;

import java.util.Arrays;

public class Sort {

    private static int[] BubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    private static int[] RecursiveBubbleSort(int[] array, int n) {
        if (n == 1)
            return array;
        else {
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(array));
            RecursiveBubbleSort(array, n - 1);
        }
        return array;
    }

    private static int[] SelectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int index = 0;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }

            if (min < array[i]) {
                int temp = array[i];
                array[i] = min;
                array[index] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    private static int[] InsertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (0 <= i && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;

            System.out.println(Arrays.toString(array));
        }

        return array;
    }

    private static int[] InsertionSortReverse(int[] array) {
        for (int j = array.length - 1; j >= 0; j--) {
            int key = array[j];
            int i = j + 1;
            while (i < array.length && array[i] > key) {
                int yoyo = array[i];
                array[i] = array[i - 1];
                array[i - 1] = yoyo;
                i++;
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    private static int[] RecursiveInsertionSort(int[] array, int n) {
        if (n <= 1)
            return array;
        else {
            RecursiveInsertionSort(array, n - 1);

            int last = array[n - 1];
            int j = n - 2;

            while (j >= 0 && array[j] > last) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = last;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }


    //****************************************



    //*****************************************************
    public static void main(String[] args) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90, -2, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println("*******************************************");
//        int[] b = BubbleSort(arr);
//        int[] b = RecursiveBubbleSort(arr, arr.length);
//        int[] b = SelectionSort(arr);
//        int[] b = InsertionSort(arr);
//        int[] b = InsertionSortReverse(arr);
        int[] b = RecursiveInsertionSort(arr, arr.length);
        System.out.println("*******************************************");
        System.out.println(Arrays.toString(b));
    }
}
