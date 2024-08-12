import java.util.Scanner;

public class Game {
    private Board board;

    public Game() {
        board = new Board();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to 2048!");
        board.printGrid();

        while (true) {
            System.out.print("Enter move (W/A/S/D) or 'Q' to quit: ");
            command = scanner.nextLine().toUpperCase();

            if (command.equals("Q")) {
                System.out.println("Thanks for playing!");
                break;
            }

            switch (command) {
                case "W":
                    // Handle move up
                    board.moveUp();
                    break;
                case "A":
                    board.moveLeft();
                    break;
                case "S":
                    // Handle move down
                    board.moveDown();
                    break;
                case "D":
                    // Handle move right
                    board.moveRight();
                    break;
                default:
                    System.out.println("Invalid command. Please enter W, A, S, D, or Q.");
                    continue;
            }

            // After each move, add a new random tile
            board.addRandomTile();
            board.printGrid();

            // Check for game over or win conditions here
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
