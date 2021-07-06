public class PermutationWithCases {
    public static void main(String[] args) {
        String s = "ab";
        String op = "";

        solve(s, op);
    }

    public static void solve(String s, String op){
        if(s.length() == 0){
            System.out.println(op);
            return;
        }

        String op1 = op, op2 = op;

        op1 += s.charAt(0);
        op2 += Character.toUpperCase(s.charAt(0));

        s = s.substring(1);

        solve(s, op1);
        solve(s, op2);
    }
}
