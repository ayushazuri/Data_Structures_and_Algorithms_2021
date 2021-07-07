public class LongestCommonSubsquence {
    public static void main(String[] args) {
        String s1 = "Ayush";
        String s2 = "Piyush";
        int m = s1.length();
        int n = s2.length();

        System.out.println(lcsRecursion(s1, s2, m, n));

        int[][] t = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                t[i][j] = -1;
            }
        }
        System.out.println(lcsMemoized(s1, s2, m, n, t));

        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i == 0 || j == 0)
                    t[i][j] = 0;
            }
        }
        System.out.println(lcsTopDown(s1, s2, m, n, dp));

    }

    public static int lcsRecursion(String s1, String s2, int m, int n){
        if(n == 0 || m == 0)
            return 0;

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return 1 + lcsRecursion(s1, s2, m-1, n-1);
        else
            return Math.max(lcsRecursion(s1, s2, m-1, n), lcsRecursion(s1, s2, m, n-1));
    }

    public static int lcsMemoized(String s1, String s2, int m, int n, int[][] t){
        if(n == 0 || m == 0)
            return 0;

        if(t[m][n] != -1)
            return t[m][n];

        if(s1.charAt(m-1) == s2.charAt(n-1))
            t[m][n] =  1 + lcsRecursion(s1, s2, m-1, n-1);
        else
            t[m][n] =  Math.max(lcsRecursion(s1, s2, m-1, n), lcsRecursion(s1, s2, m, n-1));

        return t[m][n];
    }

    public static int lcsTopDown(String s1, String s2, int m, int n, int[][] t){
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[m][n];
    }
}
