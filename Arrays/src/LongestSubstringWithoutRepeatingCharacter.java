/*
* Given a string s, find the length of the longest substring without repeating characters.
* https://leetcode.com/problems/longest-substring-without-repeating-characters/
* */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int l = 0, r = 0, len = 0, n = s.length();
        if(s.length() == 1)
            return 1;

        while(r < n){
            if(map.containsKey(s.charAt(r)))
                l = Math.max(map.get(s.charAt(r)) + 1, l);

            map.put(s.charAt(r), r);
            len = Math.max(len, r - l + 1);
            r++;
        }
        System.out.println(map);
        return len;
    }
}
