package Daily.Day5;

import java.util.Arrays;

public class Homework_Problem2 {
    public static void main(String[] args) {
        /**
         * Problem 2 — Monthly Sales Matrix
         * A company has 3 sales teams working for 4 weeks.
         * The sales data is:
         * int[][] sales = {
         *     {120, 150, 130, 170},
         *     {200, 180, 210, 190},
         *     {100, 140, 160, 120}
         * };
         *
         * Where:
         * row    → employee/team
         * column → week
         *
         *
         * Write a program that:
         *
         * Prints the complete matrix.
         * Finds the total sales of each team.
         * Finds the total sales of each week.
         * Finds the team with the highest total sales.
         * Finds the week with the highest total sales.
         * Finds the highest individual sale.
         * Prints the main diagonal only if the matrix is square.
         *
         * Expected conceptual output
         * Team 1 Total = 570
         * Team 2 Total = 780
         * Team 3 Total = 520
         *
         * Highest Team = Team 2
         *
         * Week 1 Total = 420
         * Week 2 Total = 470
         */
        int[][] sales = {
                {120, 150, 130, 170},
                {200, 180, 210, 190},
                {100, 140, 160, 120}
        };
        System.out.println("Matrix:");
        for(int [] row: sales){
            for(int col: row) {
                System.out.print(col+"\t");
            }
            System.out.println();
        }

        int[] teamTotal = new int[sales.length];
        int[] weekTotal = new int[sales[0].length];
        int teamHigh = 0;
        int weekHigh = 0;
        int individualHigh = sales[0][0];
        for (int i = 0; i < sales.length; i++) {
            boolean isLastIteration = i == sales.length-1;
            for (int j = 0; j < sales[i].length; j++) {
                teamTotal[i] += sales[i][j];
                weekTotal[j] += sales[i][j];
                if(isLastIteration && (weekTotal[j] > weekTotal[weekHigh])){
                    weekHigh = j;
                }

                if(sales[i][j] > individualHigh){
                    individualHigh = sales[i][j];
                }
            }
            if(teamTotal[i] > teamTotal[teamHigh]){
                teamHigh = i;
            }
        }
        System.out.println("Team Total: "+Arrays.toString(teamTotal));
        System.out.println("Week Total: "+Arrays.toString(weekTotal));
        System.out.println("Highest Team: Team "+ (teamHigh+1));
        System.out.println("Highest Week: Week "+(weekHigh+1));

        System.out.println("Highest Individual Sale: "+individualHigh);

        if(sales.length == sales[0].length) {
            // square
            System.out.println("Square matrix:");
            for (int i = 0; i < sales.length ; i++) {
                System.out.println(sales[i][i]);
            }
        } else {
            System.out.println("Not a square matrix");
        }
    }
}
