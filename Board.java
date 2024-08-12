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
    public boolean canMoveUp() {
        for (int col = 0; col < SIZE; col++) {
            for (int row = 1; row < SIZE; row++) {
                if (grid[row][col] != 0) {
                    if (grid[row - 1][col] == 0 || grid[row - 1][col] == grid[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check if a move down is valid
    public boolean canMoveDown() {
        for (int col = 0; col < SIZE; col++) {
            for (int row = SIZE - 2; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    if (grid[row + 1][col] == 0 || grid[row + 1][col] == grid[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check if a move left is valid
    public boolean canMoveLeft() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 1; col < SIZE; col++) {
                if (grid[row][col] != 0) {
                    if (grid[row][col - 1] == 0 || grid[row][col - 1] == grid[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Check if a move right is valid
    public boolean canMoveRight() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = SIZE - 2; col >= 0; col--) {
                if (grid[row][col] != 0) {
                    if (grid[row][col + 1] == 0 || grid[row][col + 1] == grid[row][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Move tiles up
    public void moveUp() {
        boolean moved = canMoveUp();
        if(!moved){
            System.out.println("Invalid move");
        }else{
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int insertPos = 0;

            for (int row = 0; row < SIZE; row++) {
                if (grid[row][col] != 0) {
                    if (insertPos > 0 && newCol[insertPos - 1] == grid[row][col]) {
                        newCol[insertPos - 1] *= 2;
                        moved = true;
                    } else {
                        newCol[insertPos++] = grid[row][col];
                        if (grid[row][col] != newCol[insertPos - 1]) {
                            moved = true;
                        }
                    }
                }
            }

            for (int row = 0; row < SIZE; row++) {
                if (grid[row][col] != newCol[row]) {
                    moved = true;
                }
                grid[row][col] = newCol[row];
            }
        }

        if (moved) addRandomTile();
    }}

    // Move tiles down
    public void moveDown() {
        boolean moved = false;
        for (int col = 0; col < SIZE; col++) {
            int[] newCol = new int[SIZE];
            int insertPos = SIZE - 1;

            for (int row = SIZE - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    if (insertPos < SIZE - 1 && newCol[insertPos + 1] == grid[row][col]) {
                        newCol[insertPos + 1] *= 2;
                        moved = true;
                    } else {
                        newCol[insertPos--] = grid[row][col];
                        if (grid[row][col] != newCol[insertPos + 1]) {
                            moved = true;
                        }
                    }
                }
            }

            for (int row = 0; row < SIZE; row++) {
                if (grid[row][col] != newCol[row]) {
                    moved = true;
                }
                grid[row][col] = newCol[row];
            }
        }

        if (moved) addRandomTile();
    }

    // Move tiles left
    public void moveLeft() {
        boolean moved = false;
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int insertPos = 0;

            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] != 0) {
                    if (insertPos > 0 && newRow[insertPos - 1] == grid[row][col]) {
                        newRow[insertPos - 1] *= 2;
                        moved = true;
                    } else {
                        newRow[insertPos++] = grid[row][col];
                        if (grid[row][col] != newRow[insertPos - 1]) {
                            moved = true;
                        }
                    }
                }
            }

            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] != newRow[col]) {
                    moved = true;
                }
                grid[row][col] = newRow[col];
            }
        }

        if (moved) addRandomTile();
    }

    // Move tiles right
    public void moveRight() {
        boolean moved = false;
        for (int row = 0; row < SIZE; row++) {
            int[] newRow = new int[SIZE];
            int insertPos = SIZE - 1;

            for (int col = SIZE - 1; col >= 0; col--) {
                if (grid[row][col] != 0) {
                    if (insertPos < SIZE - 1 && newRow[insertPos + 1] == grid[row][col]) {
                        newRow[insertPos + 1] *= 2;
                        moved = true;
                    } else {
                        newRow[insertPos--] = grid[row][col];
                        if (grid[row][col] != newRow[insertPos + 1]) {
                            moved = true;
                        }
                    }
                }
            }

            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] != newRow[col]) {
                    moved = true;
                }
                grid[row][col] = newRow[col];
            }
        }

        if (moved) addRandomTile();
    }

    public int[][] getGrid() {
        return grid;
    }
    }
