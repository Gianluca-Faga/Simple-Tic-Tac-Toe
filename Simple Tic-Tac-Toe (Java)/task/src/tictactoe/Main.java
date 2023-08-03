package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] grid = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
        printGrid(grid);
        char player = 'O';
        while(true){
            player = player=='O' ? 'X': 'O';
            playerMoves(player, grid, scanner);
            printGrid(grid);
            if (playerWins('X', grid)) {
                System.out.println("X wins");
                break;
            } else if (playerWins('O', grid)) {
                System.out.println("O wins");
                break;
            } else if (isGameDraw(grid)) {
                System.out.println("Draw");
                break;
            } else if(isGameStateImpossible(grid)) {
                System.out.println("Impossible");
                break;
            }
        }




    }
    private static class cellOccupiedException extends Exception{
        public cellOccupiedException(String msg){
            super(msg);
        }
    }
    public static void playerMoves(char player,char[][]grid, Scanner scanner){
        boolean success = false;
        while(!success){
            try{
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if(grid[row-1][col-1]!=' '){
                    throw new cellOccupiedException("This cell is occupied! Choose another one!");
                }
                grid[row-1][col-1]=player;
                success = true;
            }catch(InputMismatchException e){
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }catch(IndexOutOfBoundsException e){
                System.out.println("Coordinates should be from 1 to 3!");
            } catch (cellOccupiedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void printGameState(char[][] grid){
        if (isGameStateImpossible(grid)) {
            System.out.println("Impossible");
        } else if (playerWins('X', grid)) {
            System.out.println("X wins");
        } else if (playerWins('O', grid)) {
            System.out.println("O wins");
        } else if (isGameDraw(grid)) {
            System.out.println("Draw");
        } else if (gameNotFinished(grid)) {
            System.out.println("Game not finished");
        }
    }
    public static boolean playerCanMove(char player, int row, int col,char[][] grid){
        return grid[row-1][col-1]==' ';
    }
    public static char[][] fillTheGrid(String s) {
        char[][] grid = new char[3][3];
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (cnt < s.length()) {
                    grid[i][j] = s.charAt(cnt);
                    cnt++;
                } else {
                    grid[i][j] = ' '; // Aggiungi un carattere di default se la stringa s ha meno di 9 caratteri
                }
            }
        }
        return grid;
    }

    public static void printGrid(char[][] ttt) {
        String grid = "";
        for (int i = 0; i < ttt.length; i++) {
            for (int j = 0; j < ttt[i].length; j++) {
                grid += ttt[i][j];
            }
        }
        System.out.printf("---------\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "| %s %s %s |\n" +
                        "---------\n",
                grid.charAt(0), grid.charAt(1), grid.charAt(2),
                grid.charAt(3), grid.charAt(4), grid.charAt(5),
                grid.charAt(6), grid.charAt(7), grid.charAt(8));
    }

    public static boolean gameNotFinished(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    if (!playerWins('X', grid) && !playerWins('O', grid)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isGameDraw(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return !playerWins('X', grid) && !playerWins('O', grid);
    }

    public static boolean playerWins(char player, char[][] grid) {

        //check rows
        for (int i = 0; i < grid.length; i++) {
            boolean win = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (player != grid[i][j]) {
                    win = false;
                    break; // Se il giocatore non ha vinto nella colonna, non è necessario continuare il controllo
                }
            }
            if (win) return true;
        }
        // Check columns
        for (int col = 0; col < grid[0].length; col++) {
            boolean win = true;
            for (int row = 0; row < grid.length; row++) {
                if (player != grid[row][col]) {
                    win = false;
                    break; // Se il giocatore non ha vinto nella colonna, non è necessario continuare il controllo
                }
            }
            if (win) return true;
        }
        //check diagonals
        if (grid[0][0] == player && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
            return true;
        if (grid[0][2] == player && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
            return true;
        else
            return false;
    }

    public static boolean isGameStateImpossible(char[][] grid) {
        int cntX = 0;
        int cntO = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'X') {
                    cntX++;
                } else if (grid[i][j] == 'O') {
                    cntO++;
                }
            }
        }

        if (cntX > cntO + 1 || cntO > cntX + 1) {
            return true;
        } else if (playerWins('X', grid) && playerWins('O', grid)) {
            return true;
        } else {
            return false;
        }
    }

}
