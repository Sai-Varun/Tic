import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        // function 01
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ' ';
            }
        }
        printMatrix(matrix);
        int situation = 0;
        int turns = 0;
        while (situation == 0 && turns < 9) {
            enter(turns, matrix, scanner);
            printMatrix(matrix);
            situation = check(matrix);
            turns++;
        }
        switch (situation) {
            case 1:
                System.out.println("X wins");
                break;
            case 0:
                System.out.println("Draw");
                break;
            case -1:
                System.out.println("O wins");
                break;
            default:
                break;
        }
    }
    
    public static void printMatrix(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    public static int check(char[][] matrix) {
        int check = 0;
        boolean diag = (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) || (matrix[2][0] == matrix[1][1] && matrix[1][1] == matrix[0][2]);
        if (matrix[1][1] == 'X' && diag) {
            check = 1;
        } else if (matrix[1][1] == 'O' && diag) {
            check = -1;
        }
        for (int i = 0; i < 3; i++) {
            if(matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) {
                if (matrix[i][0] == 'X') {
                    check = 1;
                } else if (matrix[i][0] == 'O') {
                    check = -1;
                }
            } else if (matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) {
                if (matrix[0][i] == 'X') {
                    check = 1;
                } else if (matrix[0][i] == 'O') {
                    check = -1;
                }
            }
        }
        
        return check;
    }
    
    public static void enter(int turn, char[][] matrix, Scanner scanner) {
        boolean within = false;
        String x = "";
        String y = "";
        int xPos = 0;
        int yPos = 0;
        while (!within) {
            System.out.println("Enter the coordinates:");
            try {
                x = scanner.next();
                y = scanner.next();
                xPos = Integer.parseInt(x);
                yPos = Integer.parseInt(y);
                if (xPos < 1 || xPos > 3 || yPos < 1 || yPos > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (matrix[xPos - 1][yPos - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (turn % 2 == 0) {
                        matrix[xPos - 1][yPos - 1] = 'X';
                    } else {
                        matrix[xPos - 1][yPos - 1] = 'O';
                    }
                    within = true;
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
