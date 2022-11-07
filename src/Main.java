import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("player 1 enter your name: ");
        String p1 = in.nextLine();
        System.out.print("player 2 enter your name: ");
        String p2 = in.nextLine();

        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }


        boolean isPlayer1 = true;
        boolean gameOver = false;
        while(!gameOver){
        drawBoard(board);


        char symbol = ' ';
        if (isPlayer1) {
            symbol = 'x';
        } else {
            symbol = 'o';
        }

        if (isPlayer1) {
            System.out.println(p1 + "'s turn (x)");
        } else {
            System.out.println(p2 + "'s turn (o)");
        }


        int row = 0;
        int col = 0;

        while (true) {
            System.out.print("enter a row (0, 1, or 2): ");
            row = in.nextInt();
            System.out.print("enter a column (0, 1, or 2): ");
            col = in.nextInt();

            if (row < 0 || col < 0 || row > 2 || col > 2) {
                System.out.println("your row and column are out of bounds try again");
            } else if (board[row][col] != '-') {
                System.out.println("someone is already there!");
            } else {
                break;
            }
        }
        board[row][col] = symbol;


        if (hasWon(board) == 'x') {
            System.out.println(p1 + "has won");
            gameOver = true;
        } else if (hasWon(board) == 'o') {
            System.out.println(p2 + "has won");
            gameOver = true;

        } else {

            if (hasTied(board)) {
                System.out.println("its a tie");
                gameOver = true;

            } else {
                isPlayer1 = !isPlayer1;
            }
        }
    }
        drawBoard(board);

    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);

            }
            System.out.println();
        }
    }

    public static char hasWon(char[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];

            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-'){
            return board[2][0];
        }

        return '-';

    }

    public static boolean hasTied(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                if(board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }





}