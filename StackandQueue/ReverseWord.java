package StackandQueue;

import java.util.EmptyStackException;
import java.util.Scanner;

public class ReverseWord {
    int top;
    char[] charArray;

    public ReverseWord(int size) {
        charArray = new char[size];
        top = -1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ReverseWord obj = new ReverseWord(5);
        System.out.println("Enter any word");
        String str = scan.next();
        char[] ch = str.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            obj.push(ch[i]);
        }
        for (int i = 0; i < ch.length; i++) {
            System.out.print(obj.pop()+" ");
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
        return top == charArray.length-1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

}
