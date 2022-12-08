package easyKata;

public class Loops {

    public static void main2(String[] args) {
        int x = 20;
        while (x > 0) {
            do {
                x -= 2;
                System.out.println(" x dans le do : " + x);
            } while (x > 5);
            x--;
            System.out.println(" x après le decrement : " + x);
            System.out.println(x + "\t");
        }
    }

    public static void main3(String[] args) {
        int[][] list = {{1, 13, 5}, {1, 2, 5}, {2, 7, 2}};
        int searchValue = 2;
        int positionX = -1;
        int positionY = -1;
        PARENT_LOOP:
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j] == searchValue) {
                    positionX = i;
                    positionY = j;
                    System.out.println("positionX : " + positionX + " // " + "positionY : " + positionY);
                    //break PARENT_LOOP;
                    //break;
                }
                // System.out.println("i : " + i);
                System.out.println("j : " + j);
            }
            System.out.println("i : " + i);
            ;
        }

        if (positionX == -1 || positionY == -1) {
            System.out.println("Value " + searchValue + " not found");
        } else {
            System.out.println("Value " + searchValue + " found at: " + "(" + positionX + ", " + positionY + ")");
        }
    }

    public static void main4(String[] args) {
        FIRST_CHAR_LOOP:
        for (int a = 1; a <= 4; a++) {
            for (char x = 'a'; x <= 'c'; x++) {
                if (a == 2 || x == 'b') {
                   // continue FIRST_CHAR_LOOP;
                    continue;
                }
                System.out.println(" " + a + x);
            }
        }
    }

    public static void main(String[] args) {
        String s = "animal";
        System.out.println(s.codePointAt(1));
    }
}
