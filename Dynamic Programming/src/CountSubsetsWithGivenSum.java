public class CountSubsetsWithGivenSum {
    public static void main(String[] args) {
         int[] a = {2, 3, 5 ,6, 8, 10};
         int sum = 10;
         int n = a.length;
         int[][] t = new int[n+1][sum+1];

         for(int i=0;i<n+1;i++){
             for(int j=0;j<sum+1;j++){
                 if(i == 0)
                     t[i][j] = 0;
                 if(j == 0)
                     t[i][j] = 1;
             }
         }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(a[i-1] <= j)
                    t[i][j] = t[i-1][j] + t[i-1][j-a[i-1]];
                else
                    t[i][j] = t[i-1][j];
            }
        }

        System.out.println(t[n][sum]);
    }
}
