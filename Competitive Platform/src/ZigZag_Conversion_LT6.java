public class ZigZag_Conversion_LT6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
        System.out.println(convertBetter(s, numRows));
    }
    public static String convert(String s, int numRows) {
        int t = 0, incre = 0;
        if(numRows == 1)
            return s;

        StringBuilder[] sb = new StringBuilder[numRows];

        for(int i=0;i<sb.length;i++){
            sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
        }

        for(int i=0;i<s.length();i++){
            sb[t].append(s.charAt(i));
            if(t == 0) incre = 1;
            if( t == numRows-1) incre = -1;

            t += incre;
        }
        StringBuilder res= new StringBuilder();
        for(StringBuilder st: sb){
            res.append(st);
        }
        return res.toString();
    }
    public static String convertBetter(String s, int numRows) {
        if(numRows == 1)
            return s;

        int i=0,j=0,t=0;
        char[][] c = new char[numRows][s.length()];


        while(t < s.length()){
            for(i=0;i<numRows && t != s.length();i++){
                c[i][j] = s.charAt(t++);
            }
            i=numRows-2;
            j=j+1;
            while(i!=0 && t != s.length()){
                c[i][j] = s.charAt(t++);
                i--;
                j++;

            }

        }
        StringBuilder sb = new StringBuilder();
        for(char[] ch: c){
            for(char chh: ch){
                if(chh != '\u0000')
                    sb.append(chh);
            }
        }

        return sb.toString();
    }
}
