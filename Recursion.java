public class Recursion {
    public static void main(String[] args) {
        Recursion obj = new Recursion();

        printNumber(1);
    }
    private static void pyramidd(){
        int num = 1;
        char ch = 64;
        for (int i = 0; i < 5; i++) {
            for (int j = i-1; j < 4-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i+num; j++) {
                System.out.print(j+1);
            }
            System.out.println();
            num += 1;
            ch += 1;
        }
    }

    private boolean checker = true;
    private boolean checker2 = true;
    private boolean checker3 = false;
    private int variable = 5;
    private int variable2 = 0;
    private int variable3 = 0;
    private int variable4 = 3;
    private int var1 = 0;
    int var0;

    private void pyramidOfStars(int size) {
        if (size > 4) {
            checker = false;
            return;
        }
        if (checker) {
            pyramidOfStars(++size); //1,2,3,4,5 <-- 1st
            size = size - variable;//0,1,2
            variable2 = size + 1;//1,2,3
            variable -= 2;//3,1,-1
            checker2 = true;
        }

        if (checker2) {
            pyramidOfStars(++size);//3,4,5 <-- 2nd
            System.out.print(" ");
            if (size == variable2) {
                checker2 = false;
                checker3 = true;
                variable3 = size + variable4; //1+3=4,2+1=3,3-1=2,4-3=1,5-5=0
                var1 = variable3 + 1;//5,4,3
                variable4 -= 2;//1,-1,-3
            }
        }
        if (checker3) {
            pyramidOfStars((++variable3)); //3,4,5 <-- 3rd
            System.out.print("* ");
            if (variable3 == var1) {
                System.out.println();

            }
            checker3 = false;
            variable3--;//beacuse of instance variable..
        }

    }

    private static void pyramid() {
        int num = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i + num; j++) {
                System.out.print("*");
            }
            ++num;
            System.out.println();
        }
    }

    static boolean check = true;
    static int var = 5;

    private static void triangleOfStars(int limit) {
        if (limit < 2) {
            check = false;
            System.out.println();
            return;
        }
        if (check) {
            triangleOfStars(--limit);//5,4,3,2,1.
            limit = limit + var;
            var -= 2;
        }
        triangleOfStars(--limit);
        System.out.print("* ");
//        if (limit > 4) {
//            check = false;
//            System.out.println();
//            return;
//        }
//        if (check) {
//            triangleOfStars(++limit);
//            --limit;
//        }
//        triangleOfStars(++limit);
//        System.out.print("*");
    }

    private static void triangle() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void recursionTest(int num, String st) {
        if (num < 3) {
            recursionTest(++num, "first");
            recursionTest(++num, "second");
            System.out.println(num + " " + st);
        }
    }

    private static void printNumber(int item) {
        if (item <= 10) {
            System.out.println(item);
            printNumber(item + 1);
        }
    }

    private static void printNum(int num) {
        if (num < 10) {
            printNum(++num);
            System.out.println(num);
        }
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
