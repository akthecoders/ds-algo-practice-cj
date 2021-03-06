class NQueens {
    public boolean isValid(int i, int j, int[][] sol, int n) {
        if (i >= 0 && i < n && j >= 0 && j < n) {
            if (sol[i][j] == 1) return false;

            for (int c = 0; c < j; c++) {
                if (sol[i][c] == 1) return false;
            }

            for (int r = 0; r < i; r++) {
                if (sol[r][j] == 1) return false;
            }

            for (int r = i - 1, c = j - 1; r >=0 && c >= 0; r--, c--) {
                if (sol[r][c] == 1) return false;
            }

            for (int r = i - 1, c = j + 1; r >=0 && c < n; r--, c++) {
                if (sol[r][c] == 1) return false;
            }

            return true;
        }   
        return false;
    }

    public Sol solve(int size, int [][] sol, int row, Sol result) {
        if (row == size) {
            result.isSolved = true;
            result.solutionCount += 1;
            System.out.println("Found solution: " + result.solutionCount);
            printSol(sol); 
            return result;
        }

        for (int i = 0; i < size; i++) { // for each row.
            if (isValid(row, i, sol, size)) {
                sol[row][i] = 1;

                Sol res = solve(size, sol, row + 1, result);
                if (res.isSolved) {
                    sol[row][i] = 0;
                }
                else {
                    sol[row][i] = 0;
                }
            }
        }
        
        return result;
    }

    public void printSol(int [][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int [][] sol = new int[n][n];
        NQueens nq = new NQueens();
        Sol result = new Sol();
        result = nq.solve(n, sol, 0, result);
        System.out.println("Total solutions found:" + result.solutionCount);
    }
}

class Sol {
    boolean isSolved;
    int solutionCount;
}