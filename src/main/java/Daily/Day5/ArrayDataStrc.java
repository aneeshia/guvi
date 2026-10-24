package Daily.Day5;

import java.util.Arrays;

public class ArrayDataStrc {
    public static void main(String[] args) {
        int [] arrInt = new int[5];
        for (int i = 0; i < 5; i++) {
            arrInt[i] = (i+1) * 10;
        }
        System.out.println(Arrays.toString(arrInt));
        arrInt[2] = 'c';
        System.out.println(Arrays.toString(arrInt));


        char [] arrChar = new char[5];
        for (int i = 0; i < 5; i++) {
            arrChar[i] = (char) ('a' + i);
        }
        System.out.println(Arrays.toString(arrChar));

        System.out.println("default values:");
        int S = 5; //size
        int [] a = new int[S];
        boolean [] b = new boolean[S];
        char [] c = new char[S];
        double [] d = new double[S];
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));

        int [] aa = {1,2,3,4,5,6,7,8,9,10};
        int [] bb = aa;
        // same memory , one object, two pointers

        System.out.println(Arrays.toString(aa));
        System.out.println(Arrays.toString(bb));
        System.out.println(aa == bb); // memory address is same
        System.out.println(aa.equals(bb));// comparing values of both arrays index-wise and same so true

    }
}
