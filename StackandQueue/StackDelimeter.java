package StackandQueue;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StackDelimeter {
    int top;
    char[] charArray;

    public StackDelimeter(int size) {
        charArray = new char[size];
        top = -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackDelimeter obj = new StackDelimeter(10);
        System.out.println("Enter any Equation");
        String str = scan.nextLine();
        char[] ch = str.toCharArray();

        int count = 0, count2 = 0, count3 = 0;
        point:
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '[' || ch[i] == '{' || ch[i] == '(') {
                obj.push(ch[i]);
                count2++;
            } else if (ch[i] == ']' || ch[i] == '}' || ch[i] == ')') {
                try {
                    char cha = obj.pop();
                    count2--;
                    switch (cha) {
                        case '[':
                            cha = ']';
                            break;
                        case '{':
                            cha = '}';
                            break;
                        case '(':
                            cha = ')';
                            break;
                    }
                    if (cha != ch[i]) {
                        count3++;
                        count++;
                        break point;

                    }
                } catch (EmptyStackException e) {
                    System.out.println(e);
                    count3++;
                    count++;
                }
            }

        }
        if (count == 0 && count2 == 0) {
            System.out.println("Equation is correct");
        } else if(count3 > 0 || count2 != 0){
            System.out.println("Incorrect! Equation");
        }
    }

    private void push(char letter) {
        if (isFull()) {
            char[] newChar = new char[charArray.length * 2];
            System.arraycopy(charArray, 0, newChar, 0, charArray.length);
            charArray = newChar;
        }
        charArray[++top] = letter;
    }

    private char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return charArray[top--];
    }

    private char peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return charArray[top];
    }

    private boolean isFull() {
        return top == charArray.length - 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(charArray[i]);
        }
    }
}
