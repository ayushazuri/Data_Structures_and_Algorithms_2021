//Find subset for spaces in between the characters in string. for ABC, A B C can be subset, AB C, A BC, ABC are other subsets.

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String s = "ABC";
        String op = "";

        solve(s, op);
    }

    public static void solve(String s, String op){
        if(s.length() == 1){
            System.out.println(op +""+s);
            return;
        }

        String op1 = op, op2 = op;

        op1 += s.charAt(0);
        op2 += s.charAt(0) + " ";

        s = s.substring(1);

        solve(s, op1);
        solve(s, op2);
    }
}
