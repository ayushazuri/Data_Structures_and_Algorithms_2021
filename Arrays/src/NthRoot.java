//Not Working nth root. Check striver.

public class NthRoot {
    public int NthRoot(int n, int m)
    {
        // code here
        double l = 1, h = n;
        double e = 1e-6;
        while((h - l) > e){
            double mid = (h + l)/2;
            if(mul(mid, n) < m)
                l = mid;
            else
                h = mid;
        }
        return (int)Math.ceil(h);
    }
    double mul(double mid, int n){
        double ans = 1;
        for(int i =1;i<=n;i++){
            ans *= mid;
        }
        return ans;
    }
    public static int sqrtRoot(int x)
    {
        // Base Cases
        if (x == 0 || x == 1)
            return x;


        // Do Binary Search for floor(sqrt(x))
        long start = 1, end = x, ans=0;
        while (start <= end)
        {
            int mid = (int) ((start + end) / 2);

            // If x is a perfect square
            if (mid*mid == x)
                return (int)mid;

            // Since we need floor, we update answer when mid*mid is
            // smaller than x, and move closer to sqrt(x)
            if (mid*mid < x)
            {
                start = mid + 1;
                ans = mid;
            }
            else   // If mid*mid is greater than x
                end = mid-1;
        }
        return (int)ans;
    }
}
