package Daily.Day5;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework_Problem1 {
    public static void main(String[] args) {
        int [] scores = {70, 85, 90, 65, 90, 75};
        int target = 90;

        /**
         * Finds the highest score.
         * Finds the lowest score.
         * Calculates the average score.
         * Counts how many employees scored above the average.
         * Searches for a given score and prints all indexes where it occurs.
         * Prints the scores in reverse order.
         */
        int EmployeeCount = scores.length;

        int highestScore = 0;// highest score
        int lowestScore = scores[0];// lowest score
//        double averageScore = Math.floor(Arrays.stream(scores).average().orElse(0)* 100)/100; // average
        int scoreSum = 0;
        double averageScore = 0.00;
        int aboveAverageCount = 0;// above average
//        int [] indices = new int [EmployeeCount];
        ArrayList<Integer> indices = new ArrayList<>();// target indices
        int [] reverse = new int [EmployeeCount];// reverse
        for (int i = 0,j=EmployeeCount-1; i < EmployeeCount; i++,j--) {
            highestScore = scores[i] > highestScore ? scores[i] : highestScore;
            lowestScore = scores[i] < lowestScore ? scores[i] : lowestScore;
            if(scores[i] >= target) {
                indices.add(i);
            }
            scoreSum+=scores[i];
//            if(scores[i] >= averageScore) {
//                aboveAverageCount++;
//            }
            reverse[i] = scores[j];
        }
        averageScore = scoreSum/scores.length;
        for (int i = 0,j=EmployeeCount-1; i < EmployeeCount; i++,j--) {
            if (scores[i] >= averageScore) {
                aboveAverageCount++;
            }
        }
        System.out.println(
                "Input scores:"+Arrays.toString(scores)+
                "\nHighest score: "+highestScore +
                "\nLowest score: "+lowestScore +
//                "\nAverage Score: "+String.format("%.2f", averageScore)+

                "\nAverage: "+averageScore+
                "\nabove average count: "+aboveAverageCount+
                "\nIndices reaching target: "+indices+
                "\nReverse: "+Arrays.toString(reverse)

        );



    }
}
