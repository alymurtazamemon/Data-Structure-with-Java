public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, -1, 2, 3, 75, 83, 22,99,-3,10, 12, 89};//create the array.

        int counter = 0;
        int unsortedIndex = arr.length - 1;//declare the variable whose value is lenght -1.
        for (int i = 0; i < arr.length-1; i++) {//create outer loop,which start from 0 and less than arr lenght and incremented by 1.
            for (int j = 0; j < unsortedIndex; j++) {//declare inner loop, which start from 0 and less than variable that declared above and incremented by 1.
                int num = 0;
                counter++;
                if (arr[j] > arr[j + 1]) {
                    num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                }
            }
            unsortedIndex--;
        }
        System.out.println(counter);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}
