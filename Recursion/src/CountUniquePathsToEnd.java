//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class CountUniquePathsToEnd {

    static int numberOfPaths(int m, int n, int row, int col) {
        if(m > row || n > col)
            return 0;
        if(m == row-1 && n == col-1)
            return 1;
        return numberOfPaths(m +1, n, row, col) + numberOfPaths(m, n +1, row, col);
        // + numberOfPaths(m-1, n-1);
    }

    public static void main(String args[])
    {
        System.out.println(numberOfPaths(0, 0, 3, 3));
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
