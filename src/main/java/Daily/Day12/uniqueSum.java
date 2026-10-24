package Daily.Day12;

import java.util.HashSet;

public class uniqueSum {
    public static void main(String[] args) {

    }
    public int sumOfUnique(int[] nums) {
        int n = nums.length;
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> uniq = new HashSet<>();
        int sum = 0;

        for(int i=0 ;i<n;i++){
            boolean isDuplicate = seen.add(nums[i]);
            uniq.add(nums[i]);
            if(isDuplicate) {
                uniq.remove(nums[i]);
            }
        }
        for(int num:uniq){
            sum+=num;
        }
        return sum;
    }
}


