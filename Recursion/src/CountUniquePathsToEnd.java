//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class CountUniquePathsToEnd {

    static int numberOfPaths(int m, int n, int row, int col) {
        if(m == row-1 && n == col-1)
            return 1;

        if(m >= row || n >= col)
            return 0;

        return numberOfPaths(m +1, n, row, col) + numberOfPaths(m, n +1, row, col);
        // + numberOfPaths(m-1, n-1);
    }

    static int numberOfPathsDP(int m, int n, int row, int col, int[][] t){
        if(m == row-1 && n == col-1)
            return 1;

        if(m >= row || n >= col)
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        t[n][m] = numberOfPaths(m +1, n, row, col) + numberOfPaths(m, n +1, row, col);
        return t[n][m];
    }

    static int fastest(int m, int n){
        int N = m+n-2;
        int r=m-1;
        double res=1;
        for(int i=1;i<=r;i++)
            res = res*(N-r+i)/i;
        return (int)res;
    }
    public static void main(String args[])
    {
        System.out.println(numberOfPaths(0, 0, 3, 3));
        int[][] t = new int[4][4]; //always take one extra size
        for(int i = 0;i<3;i++){
            for(int j=0;i<3;i++)
                t[i][j] = -1;
        }
        System.out.println(numberOfPathsDP(0,0,3,3,t));
    }

//    OR

//    static int numberOfPaths(int m, int n)
//    {
//        // If either given row number is first or
//        // given column number is first
//        if (m == 1 || n == 1)
//            return 1;
//
//        // If diagonal movements are allowed then
//        // the last addition is required.
//        return numberOfPaths(m - 1, n) + numberOfPaths(m, n - 1);
//        // + numberOfPaths(m-1, n-1);
//    }
//
//    public static void main(String args[])
//    {
//        System.out.println(numberOfPaths(3, 3));
//    }
}
