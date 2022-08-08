import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] ticTacToe = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] = ' ';
            }
        }
        printMatrix(ticTacToe);
        boolean xTurn = true;
        while (!xWins(ticTacToe) && !oWins(ticTacToe) && !noEmptyCells(ticTacToe)) {
            String move;
            do {
                move = scanner.nextLine();
            }while (!aValidMove(move, ticTacToe));

            Integer line = Integer.parseInt(Character.toString(move.charAt(0)));
            Integer column = Integer.parseInt(Character.toString(move.charAt(2)));

            line--;
            column--;

            if (xTurn) {
                ticTacToe[line][column] = 'X';
                xTurn = false;
            } else {
                ticTacToe[line][column] = 'O';
                xTurn = true;
            }
            printMatrix(ticTacToe);
        }
    }
    public static void printMatrix(char[][] ticTacToe) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + ticTacToe[i][j]);
            }
            System.out.print(" |\n");
        }
        System.out.println("---------");
    }
    public static boolean aValidMove(String jogada, char[][] tictoe) {
        if(jogada.length() != 3) {
            System.out.println("The answer must follow the pattern: 0 0");
            return false;
        }

        Character line = jogada.charAt(0);
        Character column = jogada.charAt(2);

        if(!Character.isDigit(line) || !Character.isDigit(column)) {
            System.out.println("You should enter numbers!");
            return false;
        }
        Integer linePosition = Integer.parseInt(Character.toString(line));
        Integer columnPosition = Integer.parseInt(Character.toString(column));

        if(linePosition > 3 || linePosition < 0 || columnPosition > 3 || columnPosition < 0) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }
        linePosition--;
        columnPosition--;

        if (tictoe[linePosition][columnPosition] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        return true;
    }
    public static boolean xWins(char[][] tictactoe) {
        int pontosDiagonalPrincipal = 0;
        int pontosDiagonalSecundaria = 0;

        for(int i = 0; i < tictactoe.length; i++) {
            int p = 0;
            if(tictactoe[i][p] == 'X' && tictactoe[i][p+1] == 'X' && tictactoe[i][p+2] == 'X') {
                System.out.println("X wins");
                return true;
            }
            for (int j = 0; j < tictactoe.length; j++) {
                if(i == j) {
                    if(tictactoe[i][j] == 'X') {
                        pontosDiagonalPrincipal++;
                    }
                }
                if((i+1) + (j+1) == tictactoe.length+1) {
                    if(tictactoe[i][j] == 'X'){
                        pontosDiagonalSecundaria++;
                    }
                }
                if(tictactoe[p][j] == 'X'&& tictactoe[p+1][j] == 'X' && tictactoe[p+2][j] == 'X'){
                    System.out.println("X wins");
                    return true;
                }
            }
        }
        if(pontosDiagonalPrincipal == 3 || pontosDiagonalSecundaria == 3) {
            System.out.println("X wins");
            return true;
        }

        return false;
    }

    public static boolean oWins(char[][] tictactoe) {
        int pontosDiagonalPrincipal = 0;
        int pontosDiagonalSecundaria = 0;

        for(int i = 0; i < tictactoe.length; i++) {
            int p = 0;
            if(tictactoe[i][p] == 'O' && tictactoe[i][p+1] == 'O' && tictactoe[i][p+2] == 'O') {
                System.out.println("O wins");
                return true;
            }
            for (int j = 0; j < tictactoe.length; j++) {
                if(i == j) {
                    if(tictactoe[i][j] == 'O') {
                        pontosDiagonalPrincipal++;
                    }
                }
                if((i+1) + (j+1) == tictactoe.length+1) {
                    if(tictactoe[i][j] == 'O'){
                        pontosDiagonalSecundaria++;
                    }
                }
                if(tictactoe[p][j] == 'O' && tictactoe[p+1][j] == 'O' && tictactoe[p+2][j] == 'O'){
                    System.out.println("O wins");
                    return true;
                }
            }
        }
        if(pontosDiagonalPrincipal == 3 || pontosDiagonalSecundaria == 3) {
            System.out.println("O wins");
            return true;
        }

        return false;
    }

    public static boolean noEmptyCells(char[][] tictoe) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (tictoe[i][j] == ' '){
                    return false;
                }
            }
        }

        System.out.println("Draw");
        return true;
    }
}