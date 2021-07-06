// Move n - 1 rods from first to second. Then the last rod would be remaining on the first first one. Move that rod rod to the last one. then move
// all the rods from second to the last. Base condition : if there is only one rod, then just directly add to the last one, as there is no need of
// an helper/auxiliary rod here.

public class TowerOFHanoi {
    public static void main(String[] args) {
        int n = 64;
        int from = 1, aux = 2, to = 3;
        towerOfHanoi(n, from, aux, to);
    }

    public static void towerOfHanoi(int n, int from, int aux, int to){
        if(n == 1){
            System.out.println("Moving the rod from "+from+" to "+to);
            return;
        }
        towerOfHanoi(n-1, from, aux, to);
        System.out.println("moving last rod from "+from+" to "+to);
        towerOfHanoi(n-1, aux, to, from);
    }
}
