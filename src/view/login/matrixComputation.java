package view.login;

import java.util.ArrayList;
import java.util.Arrays;

public class matrixComputation {
    public static String matrixToString(int[][] a ){
        String c = "";
        for (int[] b : a){
            c += Arrays.toString(b);
            c+= "\n";
        }
        return c;
    }

    public static String historyToString(ArrayList<int[    ][]> a) {
        String r = "";
        for (int[][ ] b : a){
            r += matrixComputation.matrixToString(b);
        }
        r += "matrixEnd";
        return r;
    }
}
