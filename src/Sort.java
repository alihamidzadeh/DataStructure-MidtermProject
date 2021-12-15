public class Sort {
//    public Sort(int type, int[] array){
//
//    }

    private static int[] InsertionSort(int[] array) {
        for (int j = 1; j < array.length; j++) {
            int key = array[j];
            int i = j - 1;
            while (0 <= i && array[i] > key) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;

            for (int q = 0; q < array.length; q++)
                System.out.print(array[q] + " ");
            System.out.println();
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
            for (int q = 0; q < array.length; q++)
                System.out.print(array[q] + " ");
            System.out.println();

        }
        return array;
    }

//    private static int[] ReverseArray(int[] array) {
//        int j = 0;
//
//        for (int q = 0; q < array.length; q++)
//            System.out.print(array[q] + " ");
//        System.out.println();
//
//        for (int i = array.length-1; i >= array.length / 2; i--) {
//            int temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
//            j++;
//
//            for (int q = 0; q < array.length; q++)
//                System.out.print(array[q] + " ");
//            System.out.println();
//        }
//
//        return array;
//    }

    private static int[] SelectionSort(int[] array){
        for (int i = 0 ; i < array.length; i++){
            int min = array[i];
            int index = 0;
            for (int j = i+1; j < array.length;j++){
                if (array[j]<min) {
                    min = array[j];
                    index = j;
                }
            }
            if (min < array[i]) {
                int temp = array[i];
                array[i] = min;
                array[index] = temp;
            }

            for (int q = 0; q < array.length; q++)
                System.out.print(array[q] + " ");
            System.out.println();
        }
        return array;
    }
}
