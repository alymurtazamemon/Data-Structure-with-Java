
enum Apple {
    Jonathan, GoldenDel, RedDel
}

public class Enum {
    public static void main(String[] args) {
        Apple ap;

        ap = Apple.valueOf("Jonathan");
        System.out.println(ap);
    }
}
