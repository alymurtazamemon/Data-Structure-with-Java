public class MergeSort {
    public static void main(String[] args) {
        int[] array = {20, 48, 92, -33, 2, 3, -22};
        spillitingPhase(array, 0, array.length);
        print(array);
    }

    private static void spillitingPhase(int[] array, int start, int end) {
        if (end - start < 2) {//7-0=7,L --> 3-0=3, 1-0=1 <-- now return. R --> 3-1=2, L --> 2-1=1 <--return R--> 3-2=1 <--return
            return;          //R --> 7-3=4, L 5-3=2, 4-3=1 <-- return R 5-4=1 <-- return
        }
        int mid = (start + end) / 2;//0+7/2=3, 0+3/2=1, 1+3/2=2 R --> 3+7/2=5, 3+5/2=4
        spillitingPhase(array, start, mid);//s=0 m=3, s=0 m=1, s=1 m=2 R --> s=3 m=5, s=3 m=4
        spillitingPhase(array, mid, end);//m=1 e=3, m=2 e=3, R --> m=3 e=7, m=4 e=5
        mergingPhase(array, start, mid, end);// s=1 m=2 e=3, s=3 m=4 e=5,
    }

    private static void mergingPhase(int[] array, int start, int mid, int end) {
        if (array[mid - 1] <= array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
