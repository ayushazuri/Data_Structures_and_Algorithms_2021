import java.util.Stack;

public class ExpressionEvaluation {
    public static void main(String[] args) {
        String s = "2+(5-3*6/2)";
        System.out.println(expressionEvaluation(s));
    }
    public static int expressionEvaluation(String s){

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(char c: s.toCharArray()){
            System.out.print(c);
            if(c == ' ')
                continue;
            if(c == '('){
                operator.push(c);
            }else if(Character.isDigit(c)){
                operand.push(c-'0');
            }else if(c == ')'){
                while(!operator.isEmpty() && operator.peek() != '('){
                    char op = operator.pop();

                    int v2 = operand.pop();
                    int v1 = operand.pop();

                    operand.push(operation(v1, v2, op));
                }
                operator.pop();
            }else if(c == '+' || c == '-' || c == '*' || c == '/') {
                while (!operator.isEmpty() && operator.peek() != '(' && (precedence(c) <= precedence(operator.peek()))) {
                    char op = operator.pop();

                    int v2 = operand.pop();
                    int v1 = operand.pop();

                    operand.push(operation(v1, v2, op));
                }
                operator.push(c);
            }
        }

        while (!operator.isEmpty()) {
            char op = operator.pop();

            int v2 = operand.pop();
            int v1 = operand.pop();

            operand.push(operation(v1, v2, op));
        }

        return operand.peek();
    }

    public static int precedence(char optr){
        if(optr == '+')
            return 1;
        else if(optr == '-')
            return 1;
        else if(optr == '*')
            return 2;
        else
            return 2;
    }

    public static int operation(int op1, int op2, char optr){
        if(optr == '+')
            return op1+op2;
        else if(optr == '-')
            return op1-op2;
        else if(optr == '*')
            return op1*op2;
        else
            return op1/op2;
    }
}
