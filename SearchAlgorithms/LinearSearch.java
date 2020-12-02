package SearchAlgorithms;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {31, 2, -22, 9, 6, -2, 44};
        System.out.println(linSearch(array, 10));
        System.out.println(linSearch(array, -22));
        System.out.println(linSearch(array, 44));
        System.out.println(linSearch(array, -2));
        System.out.println();
        System.out.println(recursiveLinSearch(array, -22, 0));
    }

    private static int recursiveLinSearch(int[] array, int number, int index) {
        if (array[index] == number) {
            return index;
        }
        return recursiveLinSearch(array, number, ++index);
    }

    private static int linSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
