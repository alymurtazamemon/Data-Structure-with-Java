public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 7, -2, 8, 20, 18, -22};

        for (int i = 0; i < array.length-2; i++) {
            int shortestNumber = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[shortestNumber]){
                    shortestNumber = j;
                }
            }
            swapping(array, i, shortestNumber);
        }
        print(array);
    }
    public static void swapping(int[] array, int i, int j){
        if(i == j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
