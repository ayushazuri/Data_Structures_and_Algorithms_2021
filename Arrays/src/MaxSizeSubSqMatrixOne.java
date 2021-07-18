public class MaxSizeSubSqMatrixOne {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSubSquare(M);
    }

    private static void printMaxSubSquare(int[][] m) {
        int R = m.length;
        int C = m[0].length;
        int[][] s = new int[R][C];

        for(int i = 0;i < R;i++){
            s[i][0] = m[i][0];
        }
        for(int j=0;j < C;j++){
            s[0][j] = m[0][j];
        }

        for(int i = 1;i < R;i++){
            for (int j=1;j < C;j++){
                if(m[i][j] == 1)
                    s[i][j] = Math.min(s[i][j-1], Math.min(s[i-1][j], s[i-1][j-1])) + 1;
                else
                    s[i][j] = 0;
            }
        }

        int max_of_s = s[0][0], max_i = 0, max_j = 0;
        for(int i = 0; i < R; i++)
        {
            for(int j = 0; j < C; j++)
            {
                if(max_of_s < s[i][j])
                {
                    max_of_s = s[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println(max_of_s +" at " + max_i + " " + max_j);
    }
}
