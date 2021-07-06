public class SubsetOfString {
    public static void main(String[] args) {
        String ip = "abc";
        String op = "";

        solve(ip, op);
    }

    public static void solve(String ip, String op){
        if(ip.length() == 0){
            System.out.println(op);
            return;
        }

        String op1 = op;
        String op2 = op;
        op2 += ip.charAt(0);

        ip = ip.substring(1);

        solve(ip, op1);
        solve(ip, op2);
    }
}
