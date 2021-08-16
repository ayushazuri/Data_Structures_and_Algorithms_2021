import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }

    static int longestSubstring(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();

        int i=0, j=0, max=Integer.MIN_VALUE;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            System.out.println(map);
            if(map.size() == k){
                max = Math.max(max, j-i+1);
                j++;
            }else if(map.size() < k){
                j++;
            }else if(map.size() > k){
                while(map.size() > k){
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    System.out.println(map);
                    if(map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
                if(map.size() == k){
                    max = Math.max(max, map.size());
                }
                j++;
            }
        }
        return max;
    }
}
