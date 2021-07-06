// Print 1 to N

public class WholeNumbers {
    public static void main(String[] args) {
        int n = 7;
        print(7);
        System.out.println();
        printReverse(7);
    }

    public static void print(int n){
        if(n == 1){
            System.out.print(1+ " ");
            return;
        }

        print(n - 1);
        System.out.print(n + " ");
    }

    public static void printReverse(int n){
        if(n == 1){
            System.out.print(1 + " ");
            return;
        }

        System.out.print(n + " ");
        printReverse(n - 1);
    }
}
