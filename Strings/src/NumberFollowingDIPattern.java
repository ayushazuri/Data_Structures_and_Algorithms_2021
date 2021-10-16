//https://www.youtube.com/watch?v=GOCbsY7Arw4&ab_channel=Pepcoding
//        Given a pattern containing only I's and D's. I for increasing and D for decreasing.
//        Devise an algorithm to print the minimum number following that pattern.
//        Digits from 1-9 and digits can't repeat.

import java.util.Stack;

public class NumberFollowingDIPattern {
    public static void main(String[] args) {
        String s = "DIDDID";
        System.out.println(printMinNumberForPattern(s));
    }
    static String printMinNumberForPattern(String S) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int counter = 1;
        for (char c : S.toCharArray()) {
            if (c == 'D' || c == 'd') {
                st.push(counter++);
            } else if (c == 'I' || c == 'i') {
                st.push(counter++);
                while (!st.isEmpty()) {
                    sb.append(st.pop());
                }
            }
        }

        st.push(counter++);
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }
}
