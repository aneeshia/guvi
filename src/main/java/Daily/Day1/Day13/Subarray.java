package Daily.Day1.Day13;

public class Subarray {
    public static void main(String[] args) {
//        int [] arr = {1,12,-5,-6,50, 3};
        int [] arr = {1,12,-5,-6,50,3};
        int k=4;

        double maxAvg = findMaxAverage(arr, k);
        System.out.println(maxAvg);


    }
    public static double findMaxAverage(int[] nums, int k) {

        double maxAvg = (double)0;
        int wSum = 0;

        int i=0;
        for(; i< k;i++){
            wSum += nums[i];
        }
        maxAvg = (double)wSum/(double)k;
        System.out.println(maxAvg);

        for(; i< nums.length;i++) {
            wSum -= nums[i-k];
            wSum += nums[i+1];

            double avg = (double)wSum/ (double)k;
            System.out.println(avg);

            if(avg > maxAvg) {
                maxAvg = avg;
            }
        }
        return maxAvg;
    }
}

