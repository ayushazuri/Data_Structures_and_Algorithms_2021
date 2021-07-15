import java.util.*;

public class PrintAnagramTogetherGFG {
    public static void main(String[] args) {
        String[] words = {"act","god","cat","dog","tac"};
        List<List<String>> res = Anagrams(words);
        System.out.println(res);
    }

    static List<List<String>> Anagrams(String[] st) {

        // Your Code here
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int index = 0;
        for(String s: st){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newS = Arrays.toString(c);
            map.put(newS, map.getOrDefault(newS, new ArrayList<>()));
            map.get(newS).add(index);
            index++;
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, ArrayList<Integer>> e: map.entrySet()){
            ArrayList<Integer> temp = e.getValue();
            ArrayList<String> resS = new ArrayList<>();
            System.out.println(temp);
            for(int i: temp){
//                System.out.println();
                resS.add(st[i]);
            }
            res.add(resS);
        }
        return res;
    }
}
