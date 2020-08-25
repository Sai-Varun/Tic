import java.util.*;
import java.lang.*;

public class Tic {
    public static String won(String[][] XO) {
        // checking whether x or o have won
        for (int i = 0; i < 3; i++) {
            if ((XO[i][1].equals(XO[i][2]) && XO[i][1].equals(XO[i][0])) ||
                    (XO[1][i].equals(XO[2][i]) && XO[1][i].equals(XO[0][i]))) {
                if ("X".equals(XO[i][i])) {
                    return "X";
                } else if ("O".equals(XO[i][i])) {
                    return "O";
                }
            }
        }
        if ((XO[0][0].equals(XO[1][1]) && XO[1][1].equals(XO[2][2])) ||
                (XO[0][2].equals(XO[1][1]) && XO[1][1].equals(XO[2][0]))) {
            if ("X".equals(XO[1][1])) {
                return "X";
            } else if ("O".equals(XO[1][1])) {
                return "O";
            }
        }
        return " ";
    }
    public static void enter(String turn, String[][] XO) {
        Scanner scan = new Scanner(System.in);
        String inp1;
        String inp2;
        int pos1 = -1;
        int pos2 = -1;
        boolean entered = false;
        while(!entered) {
            System.out.println("Enter the co-ordinates: ");
            try {
                inp1 = scan.next();
                inp2 = scan.next();
                pos1 = Integer.parseInt(inp1);
                pos2 = Integer.parseInt(inp2);
                if (!((pos1 > 0 && pos1 < 4) || (pos2 > 0 && pos2 < 4) )) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (" ".equals(XO[3 - pos2][pos1 - 1])){
                    XO[3 - pos2][pos1 - 1] = turn;
                    entered = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        return;
    }
    public static void xo(String[][] XO) {
        System.out.println("---------");
        for (int i = 0; i <= 2; i++) {
            System.out.println("| " + XO[i][0] + " " + XO[i][1] + " " + XO[i][2] + " |");
        }
        System.out.println("---------");
    }
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String[][] XO = new String[3][3];
        String turn = "X";
        int x = 0;
        int o = 0;
        String winner = " ";
        boolean notOver = true;
        // breaking down string to matrix, and counting number of x, number of o's
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                XO[i][j] = " ";
            }
        }
        // printing matrix
        xo(XO);
        // input from user
        while (notOver) {
            enter(turn, XO);
            xo(XO);
            if ("X".equals(turn)) {
                turn = "O";
                x++;
            } else {
                turn = "X";
                o++;
            }
            winner = won(XO);
            if ("X".equals(winner)) {
                System.out.println("X wins");
                notOver = false;
            } else if ("O".equals(winner)) {
                System.out.println("O wins");
                notOver = false;
            } else if (x + o == 9) {
                System.out.println("Draw");
                notOver = false;
            }
        }
    }
}
