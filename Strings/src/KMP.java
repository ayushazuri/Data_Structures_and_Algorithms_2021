import java.util.Arrays;
//Not working
public class KMP {
    public static void main(String[] args) {
        String s = "aabaacaadaabaaba";
        String p = "aaba";
        searchPattern(s, p);
    }

    private static void searchPattern(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[] lps = new int[n];
        generateLPS(p, n, lps);
        System.out.println(Arrays.toString(lps));
        int i = 0, j = 0;
        while(i < m){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            if(j == n){
                System.out.println("found at" + (i-j));
                j = lps[j-1];
            }else if(i < m && j < n && s.charAt(i) != p.charAt(j) ){
                if( j!= 0)
                    j = lps[j-1];
                else
                    i++;
            }
        }
    }

    private static void generateLPS(String p, int n, int[] lps) {
        int len = 0, i = 1;
        lps[0] = 0;
        while(i < n){
            if(p.charAt(i) == p.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0)
                    len = lps[len-1];
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
