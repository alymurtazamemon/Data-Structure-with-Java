public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {20, 22, 46, 19, 5, 8, 10};

        for (int i = 1; i < array.length; i++) {
            int newElement = array[i];

            int j;
            for (j = i; j > 0 && array[j - 1] > newElement; j--) {
                array[j] = array[j - 1];
            }
            array[j] = newElement;
        }
        print(array);
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
