package Daily.Day5;

import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        int [] a = {1,10,2,6,3,8,9,4,5};
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("sort: "+ Arrays.toString(a));

        int [] b = Arrays.copyOfRange(a,0,5);
        System.out.println("copy of range: "+ Arrays.toString(b));
    }
}
