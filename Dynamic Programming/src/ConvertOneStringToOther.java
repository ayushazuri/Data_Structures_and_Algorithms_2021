//Not perfect. Try starting from 0 instead of going from last.

public class ConvertOneStringToOther {
    public static void main(String[] args) {
        String s1 = "atable";
        String s2 = "tal";
        int m = s1.length();
        int n = s2.length();
        System.out.println(convert(s1, s2, m, n));
    }

    public static int convert(String s1, String s2, int m, int n){
        if(m == 0)
            return n;
        if(n == 0)
            return m;

        if(s1.charAt(m-1) == s2.charAt(n-1))
            return convert(s1, s2, m-1, n-1);
        else{
            int c1 = 1 + convert(s1, s2, m-1, n);
            int c2 = 1 + convert(s1, s2, m-1, n-1);
            int c3 = 1 + convert(s1, s2, m, n-1);
            return 1+Math.min(convert(s1, s2, m-1, n), Math.min(convert(s1, s2, m-1, n-1), convert(s1, s2, m, n-1)));
        }
    }
}
