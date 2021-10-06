//https://leetcode.com/problems/reverse-integer/
public class Reverse_Integer_LT7 {
    public int reverse(int x) {
        if(x == 0) return 0;
        long res=0;
        while(x != 0){
            res = res*10+x%10;
            x = x/10;
        }

        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0: (int) res;
        //If the reversed result exceeds integer limit, return 0
    }
}
