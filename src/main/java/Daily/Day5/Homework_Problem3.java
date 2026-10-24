package Daily.Day5;

public class Homework_Problem3 {
    public static void main(String[] args) {
        /**
         * Problem 3 — Employee ID & Report Generator
         * You have employee records:
         *
         * String[] names = {
         *     "Rahul",
         *     "Amit",
         *     "Priya",
         *     "Neha"
         * };
         *
         * int[][] monthlyScores = {
         *     {80, 85, 90},
         *     {70, 75, 80},
         *     {95, 90, 92},
         *     {60, 65, 70}
         * };
         *
         * Each row of monthlyScores belongs to the corresponding employee.
         *
         * For example:
         * Rahul → 80, 85, 90
         * Amit  → 70, 75, 80
         * Priya → 95, 90, 92
         * Neha  → 60, 65, 70
         *
         * Your task is to generate a complete employee report.
         *
         * Expected output
         * ===== EMPLOYEE PERFORMANCE REPORT =====
         *
         * Employee: Rahul
         * Scores: 80, 85, 90
         * Total: 255
         * Average: 85.00
         * Status: EXCELLENT
         *
         * Employee: Amit
         * Scores: 70, 75, 80
         * Total: 225
         * Average: 75.00
         * Status: GOOD
         *
         * Employee: Priya
         * Scores: 95, 90, 92
         * Total: 277
         * Average: 92.33
         * Status: EXCELLENT
         *
         * Employee: Neha
         * Scores: 60, 65, 70
         * Total: 195
         * Average: 65.00
         * Status: NEEDS IMPROVEMENT
         *
         * Condition::::::::::
         * Status rules
         * Average >= 90 → EXCELLENT
         * Average >= 75 → GOOD
         * Average >= 60 → AVERAGE
         * Below 60     → NEEDS IMPROVEMENT
         */
        String[] names = {
                "Rahul",
                "Amit",
                "Priya",
                "Neha"
        };

        int[][] monthlyScores = {
                {80, 85, 90},
                {70, 75, 80},
                {95, 90, 92},
                {60, 65, 70}
        };

        String [] status = {
                "EXCELLENT", "GOOD", "AVERAGE", "NEEDS IMPROVEMENT"
        };

        System.out.println("\n===== EMPLOYEE PERFORMANCE REPORT =====");

        int employeeIndex=0;
        for (int [] employeeScores : monthlyScores) {
            System.out.println("Employee: "+names[employeeIndex]);
            System.out.print("Scores: ");
            int total = 0;
            for (int j = 0; j < employeeScores.length; j++) {
                System.out.print(employeeScores[j]+ ((j<employeeScores.length-1)?", ":""));
                total += employeeScores[j];
            }
            System.out.println();
            System.out.println("Total: "+total);
            double employeeAverage = (double) total /employeeScores .length;
            System.out.printf("Average: %.2f%n",employeeAverage);

            int statusIndex = 3;
            if(employeeAverage >= 90) {
                statusIndex = 0;
            } else if(employeeAverage >= 75) {
                statusIndex = 1;
            } else if(employeeAverage >= 60) {
                statusIndex = 2;
            }
            System.out.println("Status: "+status[statusIndex]);
            System.out.println();System.out.println();
            employeeIndex++;
        }
    }
}
