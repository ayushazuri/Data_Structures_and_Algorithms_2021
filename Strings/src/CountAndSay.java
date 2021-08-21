//https://leetcode.com/problems/count-and-say/
//https://www.geeksforgeeks.org/look-and-say-sequence/

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6)); //5th is 111221
    }
    
    public static String countAndSay(int n){ //better to use StringBuilder
        if(n == 1) return "1";
        if(n == 2) return "11";
        String s = "11";
        for(int i = 3;i <= n; i++){
            s += "$";
            int count = 1; String temp = "";
            for(int j=1;j<s.length();j++){
                if(s.charAt(j) != s.charAt(j-1)){
                    temp += count;
                    temp += s.charAt(j-1);
                    count = 1;
                }else{
                    count++;
                }
            }
            s = temp;
        }

        return s;
    }
}
