package Trees;

public class HuffmanTree {
    PriorityQueue ob;
    private CharNode head;
    private String[] array = new String[28];

    public static void main(String[] args) {
        HuffmanTree obj = new HuffmanTree();
        obj.insert("hello world");
        System.out.println(obj.deCode("001 000 10 10 111 010 111 1101 10 1100"));
    }

    public void insert(String string) {
        countCharacter(string.toUpperCase());
        head = createTree();
        huffmanCode(head, new StringBuilder());
    }

    private void huffmanCode(CharNode root, StringBuilder code) {
        if(root == null){
            System.out.println("Root is Null");
            return;
        }
        if (root.ls == null && root.rs == null) {
            codeTable(root.character, code + "");
            return;
        }
        huffmanCode(root.ls, code.append("0"));
        code.delete(code.length() - 1, code.length());
        huffmanCode(root.rs, code.append("1"));
        code.delete(code.length() - 1, code.length());
    }

    private void codeTable(String ch, String code) {
        int ASCII;
        if (ch.equals("sp")) {
            ASCII = 91;
        } else if (ch.equals("\n")) {
            ASCII = 92;
        } else {
            ASCII = ch.charAt(0);
        }
        int index = ASCII - 65;
        array[index] = code;
    }

    public void enCode(String string) {
        char[] arr = string.toCharArray();
        int ASCII, index;
        for (int i = 0; i < arr.length; i++) {
            ASCII = arr[i];
            index = ASCII - 65;
            System.out.print(array[index] + ", ");
        }
    }

    public String deCode(String string) {
        CharNode current = head;
        String str = "";
        char[] array = string.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0') {
                if (current.ls == null) {
                    return "This code has an error, something is wrong in this code.";
                }
                current = current.ls;
            } else if (array[i] == '1') {
                if (current.rs == null) {
                    return "This code has an error, something is wrong in this code.";
                }
                current = current.rs;
            } else {
                str = str + current.character + " ";
                current = head;
            }
        }
        str = str + current.character;
        return str;
    }

    public void inOrder(CharNode n) {
        if (n != null) {
            inOrder(n.ls);
            System.out.println(n.character + " it's frequency --> " + n.characterFrequency);
            inOrder(n.rs);
        }
    }

    private void countCharacter(String string) {
        char[] array = string.toCharArray();
        String[] store = new String[array.length];
        int x = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z' || array[i] == ' ' || array[i] == '\n') {
                boolean check = true;
                point:
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        check = false;
                        break point;
                    }
                }
                if (check) {
                    if (array[i] == ' ') {
                        store[++x] = "sp";
                    } else if (array[i] == '\n') {
                        store[++x] = "lf";
                    } else
                        store[++x] = array[i] + "";
                }
            }
        }
        Frequency(array, store, x);
    }

    private void Frequency(char[] charArray, String[] stringArray, int lenght) {
        int count = 0;
        int[] intArray = new int[lenght + 1];
        for (int i = 0; i <= lenght; i++) {
            for (int j = 0; j < charArray.length; j++) {
                if (stringArray[i].equals(charArray[j] + "") || stringArray[i].equals("sp") && charArray[j] == ' ' ||
                        stringArray[i].equals("lf") && charArray[j] == '\n') {
                    count++;
                }
            }
            if (count > 0) {
                intArray[i] = count;
            }
            count = 0;
        }
        createNodes(intArray, stringArray);
        //print(intArray, stringArray);
    }

    private void createNodes(int[] intArray, String[] stringArray) {
        ob = new PriorityQueue(intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            ob.insert(new CharNode(stringArray[i], intArray[i]));
        }
    }

    private CharNode createTree() {
        CharNode newTree = null;
        if (ob.front == 0) {
            return ob.delete();
        } else {
            while (ob.front != 0) {
                CharNode firstTree = ob.delete();
                CharNode secondTree = ob.delete();
                newTree = new CharNode(" ", firstTree.characterFrequency + secondTree.characterFrequency);
                newTree.ls = firstTree;
                newTree.rs = secondTree;
                ob.insert(newTree);
            }
            return newTree;
        }
    }

    private void print(int[] intArray, String[] stringArray) {
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(stringArray[i] + " --> " + intArray[i] + " Times.");
        }
    }
}

class CharNode {
    CharNode ls, rs;
    String character;
    int characterFrequency;

    public CharNode(String character, int characterFrequency) {
        this.character = character;
        this.characterFrequency = characterFrequency;
    }
}
