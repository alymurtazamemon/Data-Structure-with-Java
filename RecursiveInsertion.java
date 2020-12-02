public class RecursiveInsertion {
    public static void main(String[] args) {
        int[] array = {100,90,30,-22,-10,7,2, 1};
        insertionSort(array,1);
        print(array);
    }
    public static void insertionSort(int[] array, int size){
        if(size == array.length){
            return;
        }
        int newElement = array[size];

        int j;
        for (j = size; j > 0 && array[j - 1] > newElement; j--) {
            array[j] = array[j - 1];
        }
        array[j] = newElement;

        insertionSort(array,size+1);
    }
    private static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
