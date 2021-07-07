public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int w = 7;
        int n = wt.length;

        System.out.println(recursionKnapsack(wt, val, wt.length, w));

        int[][] t = new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                t[i][j] = -1;
            }
        }
        System.out.println(memoizedKnapsack(wt, val, wt.length, w, t));

        int[][] dp = new int[n+1][w+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<w+1;j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }

        System.out.println(topDownKnapsack(wt, val, wt.length, w, dp));
    }

    public static int recursionKnapsack(int[] wt, int [] val, int n, int w){
        if(n == 0 || w == 0)
            return 0;

        if(wt[n-1] <= w){
            return Math.max(val[n-1] + recursionKnapsack(wt, val, n-1, w - wt[n-1]), recursionKnapsack(wt, val, n-1, w));
        }else{
            return recursionKnapsack(wt, val, n-1, w);
        }
    }

    public static int memoizedKnapsack(int[] wt, int [] val, int n, int w, int[][] t){
        if(n == 0 || w == 0)
            return 0;

        if(t[n][w] != -1){
            return t[n][w];
        }
        if(wt[n-1] <= w){
            t[n][w] = Math.max(val[n-1] + recursionKnapsack(wt, val, n-1, w - wt[n-1]), recursionKnapsack(wt, val, n-1, w));
        }else{
            t[n][w] = recursionKnapsack(wt, val, n-1, w);
        }

        return t[n][w];
    }

    public static int topDownKnapsack(int[] wt, int [] val, int n, int w, int[][] t){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){

                if(wt[i-1] <= j){
                    t[i][j] = Math.max(val[i-1] + t[i-1][j - wt[i-1]], t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }

            }
        }

        return t[n][w];
    }
}
