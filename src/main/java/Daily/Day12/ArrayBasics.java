package Daily.Day12;

import java.util.Arrays;

public class ArrayBasics {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4};
        int len = arr1.length;

        int[] arr2 = new int[len];
        arr2[0] = arr1[0];

        for(int i=1; i<len; i++) {
            arr2[i] = arr2[i-1] + arr1[i];
        }
        System.out.println(Arrays.toString(arr2));
    }
}
