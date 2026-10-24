package Daily.Day5;

import java.util.Arrays;

public class OperationsInArray {
    public static void main(String[] args) {

        // CRUD - create, read, update, delete

        // CREATE
        int [] a = {1,2,3,4,5,6,7,8,9,10};

        int length = a.length;
        //READ
        for (int i = 0; i < length; i++) {
            System.out.println(a[i]);
        }
        for( int tempV: a){
            System.out.println(tempV);
        }
        System.out.println(Arrays.toString(a));

        //UPDATE
        a[1] = 100;
        System.out.println(Arrays.toString(a));


        //INSERTION
        // can you insert inside a exisitng array - NO
        // insert 99 at index 2

        // create a new object  old size 10 + new size 1 = 11
        int [] b = new int [11];
        System.out.println("inserting.." + b.length);
        for (int i = 0; i < b.length; i++) {
            if(i<2)
                b[i] = a[i];
            else if(i==2)
                b[i] = 99;
            else
                b[i] = a[i-1];
        }
        System.out.println(Arrays.toString(b));


        // delete index 1 the value 100
        int [] c = new int[10];
        System.out.println("deleting.." + c.length);
        for (int i = 0; i < b.length; i++) {
            if(i<1)
                c[i] = b[i];
            else if(i>1)
                c[i-1] = b[i];
        }
        System.out.println(Arrays.toString(c));


    }
}
