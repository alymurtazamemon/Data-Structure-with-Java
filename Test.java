import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Test obj = new Test();
        int[] array = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};
        //ATM(array);
        //CountCharacter();
        //luckynumber();
        System.out.println(obj.commonDividend(24, 12));
        System.out.println(obj.commonMultiple(5, 20));
        obj.method(new StringBuffer("Pakistan"));
    }
    private void Matrix(int[][] a, int[][] b){

    }
    private void method(StringBuffer str) {
        String st = str.reverse().toString();
        System.out.println(st);
    }

    private int commonMultiple(int a, int b) {
        int num = 2;
        int x = 0;
        int[] array = new int[100];
        while (a != 1 || b != 1) {
            if (a % num == 0 && b % num == 0) {
                a /= num;
                b /= num;
                array[x] = num;
                x++;
            } else if (a % num == 0) {
                a = a / num;
                array[x] = num;
                x++;
            } else if (b % num == 0) {
                b /= num;
                array[x] = num;
                x++;
            } else {
                num++;
            }
        }
        int num1 = array[0];
        for (int i = 1; i < x; i++) {
            num1 = num1 * array[i];
        }
        return num1;
    }

    private int commonDividend(int a, int b) {
        int count = 1;
        for (int i = 1; i < 100; i++) {
            if (a % i == 0 && b % i == 0) {
                count = i;
            }
        }
        return count;
    }

    private static void luckynumber() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your date of birth ");
        int date = scan.nextInt();

        int i, sum = 0;
        while (date > 9) {
            while (date != 0) {
                i = date % 10;
                sum += i;
                date = date / 10;
            }
            date = sum;
            sum = 0;
        }
        System.out.println("Your lucky number is : " + date);
    }

    private static void CountCharacter() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Name or Any Letter");
        String str = scan.nextLine();
        char[] ch = str.toCharArray();
        char[] ch1 = new char[ch.length];

        for (int i = 0; i < ch.length; i++) {
            int count = 0;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(ch[i]);
                ch1[i] = ch[i];
            }
        }
        sort(ch1);
        print(ch1);
    }

    private static void sort(char[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    char ch = array[i];
                    array[i] = array[j];
                    array[j] = ch;
                }
            }
        }
    }

    private static void print(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void ATM(int[] array) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter amount here");
        int amount = scan.nextInt();

        int Notes;
        for (int i = 0; i < array.length; i++) {
            Notes = amount / array[i];
            System.out.println(array[i] + " * " + Notes + " = " + (array[i] * Notes));
            amount -= (Notes * array[i]);
        }
    }
}
