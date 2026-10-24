package Daily.Day16;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {

        int [] arr = {5,1,4,3,6,2};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));

        int [] arr2 = {10,1,5,6,20,30,1,2,4};

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(bubbleSort(arr2)));

        int [] arr3 = {10,1,5,6,20,30,7,2,4};
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(selectionSort(arr3)));

        int [] arr4 = {3,1,2,5,4,7,8,9,50,30};
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(selectionSort(arr4)));

    }
    public static int[] bubbleSort(int[] a) {
        for (int i=0; i<a.length - 2;i++){

            for(int j=0; j< a.length -1 - i;j++){
//                System.out.println(i + ","+j+":\t" + a[j] + " > "+ a[j+1] +" = " + (a[j] > a[j+1]));
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] selectionSort(int[] a) {
        for(int i=0 ; i< a.length; i++) {
            int min = i;
            for(int j=i+1; j < a.length;j++){
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }

    public static int[] insertionSort(int[] a) {
        for(int i=0 ; i< a.length; i++) {
            int temp = a[i];
            int j = i-1;
            while(j>=0 && a[j]>temp){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
        return a;
    }
}
