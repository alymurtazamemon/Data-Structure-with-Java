public class RecursiveSelection {
    public static void main(String[] args) {
        int[] array = {-13,22,87,110,90,42,21};
        selectionSort(array, array.length-1);
        print(array);                                           //-22,14,66,7,9,2,4
    }
    public static void selectionSort(int[] array, int size){
        if(size == 0){
            return;
        }
        int largestNumber = size;
        for (int i = 0; i < size; i++) {
            if(array[i] > array[largestNumber]){
                largestNumber = i;
            }
        }
        int temp = array[largestNumber];
        array[largestNumber] = array[size];
        array[size] = temp;
        selectionSort(array,size-1);
    }
    public static void print(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
