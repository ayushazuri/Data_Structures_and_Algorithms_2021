import java.util.HashMap;

public class LargestSubarrayWithXorAsK {
    public int subArray(int[] a, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0, cnt = 0;
        for(int i=0;i<a.length;i++){
            xor=xor^a[i];
            if(map.containsKey(xor^k))
                cnt += map.get(xor^k);
            if(xor == k)
                cnt += 1;

            if(map.get(xor) != null)
                map.put(xor, map.get(xor)+1);
            else
                map.put(xor, 1);
        }
        return cnt;
    }
}
