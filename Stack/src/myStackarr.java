public class myStackarr {
    static int counter = 0;
    public static void main(String[] args) {
        int[] stack = new int[10];
        push(stack, 11);
        push(stack, 22);
        push(stack, 33);
        System.out.println(peek(stack));

        push(stack, 44);
        System.out.println(counter);

        print(stack);
        pop(stack);
        print(stack);
        push(stack, 55);
        print(stack);

        System.out.println(counter);
        System.out.println(peek(stack));


    }

    public static void push(int[] stack, int data){
        stack[counter] = data;
        counter++;
    }

    public static void pop(int[] stack){
        if(counter == 0) return;
        counter--;
        stack[counter] = 0;
    }

    public static int peek(int[] stack){
        return stack[counter-1];
    }
    public static void print(int[] stack){
        for(int i: stack){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
