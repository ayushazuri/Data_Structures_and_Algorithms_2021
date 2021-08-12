import java.util.HashMap;

public class CheckIfPairsAreDivisibleByK {
    public static void main(String[] args) {
        int arr[] = { 92, 75, 65, 48, 45, 35};
        int k = 10;

        System.out.println(checkIfDivisble(arr, k));
    }

    public static boolean checkIfDivisble(int[] a, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: a){
            int rem = i%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        System.out.println(map);
        for(int i: a){
            int rem = i%k;
            if(i == 0){
                int freq = map.get(rem);
                if(freq % 2 != 0)
                    return false;
            }else if(2*rem == k){
                int freq = map.get(rem);
                if(freq % 2 != 0)
                    return false;
            }else{
                int freq = map.get(rem);
                if(!map.containsKey(k-rem))
                    return false;
                int otherFreq = map.get(k-rem);

                if(freq != otherFreq)
                    return false;
            }
        }
        return true;
    }
}
