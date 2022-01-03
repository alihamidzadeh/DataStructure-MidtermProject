package Application.Sort;

import Application.Pages.SortResultPage;

import java.util.Arrays;

public class Sort {

    private static int[] BubbleSort(int[] array) {
        int n = array.length;
        String str = "";
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            str += Arrays.toString(array);
            str += "\n";
        }
        SortResultPage.output.setText(str);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }

    public static String strr = "";

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
            strr += Arrays.toString(array);
            strr += "\n";
            RecursiveBubbleSort(array, n - 1);
        }
        SortResultPage.output.setText(strr);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }

    private static int[] SelectionSort(int[] array) {
        String str = "";

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
            str += Arrays.toString(array);
            str += "\n";
        }
        SortResultPage.output.setText(str);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }

    private static int[] InsertionSort(int[] array) {
        String str = "";

        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (0 <= i && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;

            str += Arrays.toString(array);
            str += "\n";
        }
        SortResultPage.output.setText(str);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }

    private static int[] InsertionSortReverse(int[] array) {
        String str = "";
        for (int j = array.length - 1; j >= 0; j--) {
            int key = array[j];
            int i = j + 1;
            while (i < array.length && array[i] > key) {
                int yoyo = array[i];
                array[i] = array[i - 1];
                array[i - 1] = yoyo;
                i++;
            }
            str += Arrays.toString(array);
            str += "\n";
        }

        SortResultPage.output.setText(str);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }

    static String strrr = "";

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

            strrr += Arrays.toString(array);
            strrr += "\n";
        }

        SortResultPage.output.setText(strrr);
        SortResultPage.result.setText(Arrays.toString(array));
        return array;
    }


    //****************************************


    public Sort(int type, int[] array) {
        switch (type) {
            case 0:
                BubbleSort(array);
                return;
            case 1:
                RecursiveBubbleSort(array, array.length);
                return;
            case 2:
                SelectionSort(array);
                return;
            case 3:
                InsertionSort(array);
                return;
            case 4:
                InsertionSortReverse(array);
                return;
            case 5:
                RecursiveInsertionSort(array, array.length);
                return;
        }
    }


}
