public class CountingSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 8, 9, 1, 5, 2, 4, 5, 7};
        int[] secondArray = new int[array.length];
        countingSort(array,secondArray);
        print(secondArray);
    }

    private static void countingSort(int[] array,int[] secondArray) {
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            secondArray[num-1] += 1;
        }
    }
    private static void print(int[] secondArray){
        for (int i = 0; i < secondArray.length; i++) {
            if(secondArray[i] > 0){
                int rec = secondArray[i];

            }
        }
    }
}
