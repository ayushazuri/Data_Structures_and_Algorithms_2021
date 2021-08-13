import java.util.ArrayList;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 3;
        int open = n, close = n;
        String op = "";
        ArrayList<String> res = new ArrayList<>();
        generateParenthesis(open, close, op, res);
        System.out.println(res);
    }

    private static void generateParenthesis(int open, int close, String op, ArrayList<String> res) {
        if(open == 0 && close == 0){
            res.add(op);
            return;
        }

        if(open != 0){
            String op1 = op + "(";
            generateParenthesis(open-1, close, op1, res);
        }

        if(close > open){
            String op2 = op + ")";
            generateParenthesis(open, close-1, op2, res);
        }
    }
}
