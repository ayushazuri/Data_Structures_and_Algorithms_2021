import java.util.Stack;

public class ReverseAnStack {
//    static Stack<Integer> stack = new Stack<>();
//    public static void main(String[] args) {
//
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//
//        revere();
//        System.out.println(stack);
//    }
//
//    public static void revere(){
//        if(stack.size() > 0){
//            int temp = stack.peek();
//            stack.pop();
//            revere();
//            insert(temp);
//        }
//    }
//
//    public static void insert(int temp){
//        if(stack.isEmpty()){
//            stack.push(temp);
//            return;
//        }else{
//            int temp1 = stack.peek();
//            stack.pop();
//            System.out.println(temp1);
//            insert(temp1);
//            stack.push(temp1);
//        }
//    }

    static Stack<Character> st = new Stack<>();
    static void insert_at_bottom(char x)
    {

        if(st.isEmpty())
            st.push(x);

        else
        {
            char a = st.peek();
            st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }
    static void reverse()
    {
        if(st.size() > 0)
        {
            char x = st.peek();
            st.pop();
            reverse();

            insert_at_bottom(x);
        }
    }


    public static void main(String[] args)
    {
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');

        System.out.println("Original Stack");

        System.out.println(st);
        reverse();

        System.out.println("Reversed Stack");

        System.out.println(st);
    }

}
