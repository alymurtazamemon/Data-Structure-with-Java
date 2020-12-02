package SearchAlgorithms;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] array = {1, 4, 6, 9, 11, 23, 55, 77, 99, 229};
        char[] arr = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(charBinarySearch(arr, 'G', 0, arr.length));
        System.out.println("Enter the Number you want to search ??");
        System.out.println("Number you search is at index : " + recursiveBinarySearch(array, scan.nextInt(), 0, array.length));
    }
    private static int recursiveBinarySearch(int[] array, int input, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int midpoint = (start + end) / 2;

        if (input < array[midpoint]) {
            return recursiveBinarySearch(array, input, start, midpoint);
        } else if (input == array[midpoint]) {
            return midpoint;
        } else {
            return recursiveBinarySearch(array, input, midpoint + 1, end);
        }
    }
    public static void iterativeBinarySearch(int[] array, int key) {
        int start = 0;
        int end = array.length;
        int mid = (start + end) / 2;

        if (key == array[mid]) {


        }

    }

    private static String charBinarySearch(char[] array, char input, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;

        if (input == array[mid]) {
            return mid + "";
        } else if (input < array[mid]) {
            return charBinarySearch(array, input, start, mid);
        } else {
            return charBinarySearch(array, input, mid + 1, end);
        }
    }


}
