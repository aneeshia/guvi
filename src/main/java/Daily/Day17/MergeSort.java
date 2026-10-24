package Daily.Day17;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr1[] = {1,6,8,3,10,7};
        int arr2[] = {4,9,2,5,13,12,15,11};






        int result[] = merge(arr1, arr2);

    }
    static void mergeSort() {
        // divide and concur
    }
    public static int[] merge(int [] arr1, int [] arr2) {


        int l1 = arr1.length;
        int l2 = arr2.length;
        int result[] = new int[l1+l2];

        int p1 = 0;
        int p2 = 0; // 2 pointers
        int i = 0;

        while(p1<l1 && p2<l2) {
            if(arr1[p1] <= arr2[p2]) {
                result[i] = arr1[p1];
                i++;
                p1++;
            }
            else if (arr2[p2] < arr1[p1]) {
                result[i] = arr1[p2];
                i++;
                p2++;
            }
        }

        while(p1<l1) {
            result[i] = arr1[p1];
            i++;p1++;
        }

        while(p2<l2) {
            result[i] = arr2[p2];
            i++;p2++;
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(result));
        return result;
    }
}
