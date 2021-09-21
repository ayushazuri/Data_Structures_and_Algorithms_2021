//https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations
        that the number could represent. Return the answer in any order.*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationOfPhone {
    public List<String> letterCombinations(String digits) {
        String[] let = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");

        if(digits.length() == 0)
            return res;

        while(!queue.isEmpty()){
            String temp = queue.poll();

            if(temp.length() == digits.length()){
                res.add(temp);
                continue;
            }


            String letter = let[digits.charAt(temp.length())-'0'];
            // System.out.println(letter);
            for(int i=0;i<letter.length();i++){
                queue.add(temp + letter.charAt(i));
            }
        }

        return res;
    }
    public List<String> letterCombinationsBetter(String digits) {
        String[] let = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> res = new LinkedList<>();


        if(digits.length() == 0)
            return res;

        res.add("");
        while(digits.length() != res.peek().length()){
            String temp = res.remove();

            String letter = let[digits.charAt(temp.length())-'0'];

            for(char c: letter.toCharArray()){
                res.addLast(temp + c);
            }
        }

        return res;
    }
}
