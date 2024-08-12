public class Board {
        private int[][] grid;
        private static final int SIZE = 4;

        public Board() {
            grid = new int[SIZE][SIZE];
            initializeBoard();
        }

        // Method to initialize the board with two random tiles
        private void initializeBoard() {
            addRandomTile();
            addRandomTile();
        }

        // Method to add a random tile (2 or 4) to an empty spot on the grid
        public void addRandomTile() {
            int value = Math.random() < 0.9 ? 2 : 4;
            int row, col;
            do {
                row = (int) (Math.random() * SIZE);
                col = (int) (Math.random() * SIZE);
            } while (grid[row][col] != 0);
            grid[row][col] = value;
        }

        // Method to print the current state of the grid (for debugging purposes)
        public void printGrid() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(grid[i][j] + "\t");
                }
                System.out.println();
            }
        }
    public void moveUp() {
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int insertPos = 0;

            for (int row = 0; row < SIZE; row++) {
                if (grid[row][col] != 0) {
                    if (insertPos > 0 && newCol[insertPos - 1] == grid[row][col]) {
                        newCol[insertPos - 1] *= 2;
                    } else {
                        newCol[insertPos++] = grid[row][col];
                    }
                }
            }

            for (int row = 0; row < SIZE; row++) {
                grid[row][col] = newCol[row];
            }
        }
    }

    // Move tiles down
    public void moveDown() {
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int insertPos = SIZE - 1;

            for (int row = SIZE - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    if (insertPos < SIZE - 1 && newCol[insertPos + 1] == grid[row][col]) {
                        newCol[insertPos + 1] *= 2;
                    } else {
                        newCol[insertPos--] = grid[row][col];
                    }
                }
            }

            for (int row = 0; row < SIZE; row++) {
                grid[row][col] = newCol[row];
            }
        }
    }

    // Move tiles left
    public void moveLeft() {
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int insertPos = 0;

            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] != 0) {
                    if (insertPos > 0 && newRow[insertPos - 1] == grid[row][col]) {
                        newRow[insertPos - 1] *= 2;
                    } else {
                        newRow[insertPos++] = grid[row][col];
                    }
                }
            }

            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = newRow[col];
            }
        }
    }

    // Move tiles right
    public void moveRight() {
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int insertPos = SIZE - 1;

            for (int col = SIZE - 1; col >= 0; col--) {
                if (grid[row][col] != 0) {
                    if (insertPos < SIZE - 1 && newRow[insertPos + 1] == grid[row][col]) {
                        newRow[insertPos + 1] *= 2;
                    } else {
                        newRow[insertPos--] = grid[row][col];
                    }
                }
            }

            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = newRow[col];
            }
        }
    }
    }
