//Incomplete

public class FindPathInmxmMatrix {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 } };
        int maxLengthOfPath = m + n - 1;
        printMatrix(mat, m, n, 0, 0, new int[maxLengthOfPath], 0);
    }

    public static void printMatrix (int[][] mat, int m, int n, int i, int j, int[] path, int ind){
        path[ind] = mat[i][j];

        if(i == m-1){
            for(int k = j+1;k<n;k++){
                path[ind+k-j] = mat[i][k];
            }
            for (int value : path) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        if(j == n-1){
            for(int k = i+1;k<m;k++){
                path[ind + k - i] = mat[k][j];
            }
            for (int value : path) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        printMatrix(mat, m, n, i+1, j, path, ind+1);
        printMatrix(mat, m, m, j, j+1, path, ind+1);

    }
}
