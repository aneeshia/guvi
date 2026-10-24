package Daily.Day6;

public class Homework_Problem1 {
    /**
     * ======================================================
     * Problem 1: Student Result Processing System
     * =======================================================
     * Problem Statement
     *
     * Write a Java program to process the result of a student.
     * The program should accept the student's name and marks in three subjects and display the total marks, percentage, grade and result status.
     * Requirements
     * Create the following methods:
     *
     * static int calculateTotal(int marks1, int marks2, int marks3)
     * static double calculatePercentage(int total)
     * static char calculateGrade(double percentage)
     * static boolean isPassed(double percentage)
     * static void displayResult(String name, int total,double percentage, char grade)
     *
     * Create another overloaded version of displayResult() that accepts only the student's name.
     *
     * Rules
     * Passing percentage: 40%
     * Grade A: 80% and above
     * Grade B: 60% to 79%
     * Grade C: 50% to 59%
     * Grade D: 40% to 49%
     * Grade F: below 40%
     *
     * Sample Input
     * Name: Rahul
     * Marks: 75 82 68
     *
     * Sample Output
     * Student Name: Rahul
     * Total Marks: 225
     * Percentage: 75.0
     * Grade: B
     * Result: PASS
     */
    public static void main(String[] args) {
        String studentName = "Rahul";
        int [] studentMarks = { 75, 82, 68};
        int totalMarks = calculateTotal(studentMarks);
        double percentage = calculatePercentage(totalMarks);
        char grade = calculateGrade(percentage);
        String result = calculateResult(grade);

        System.out.println("Output\nStudent Name: "+studentName);
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Percentage: "+percentage);
        System.out.println("Grade: "+grade);
        System.out.println("Result: "+result);


    }

    static int calculateTotal(int [] marksList) {
        int sum = 0;
        for (int marks: marksList){
            sum+=marks;
        }
        return sum;
    }
    static double calculatePercentage(int total) {
        return (double) total /(3 * 100) * 100;
    }
    static char calculateGrade(double percentage){
        if(percentage >= 80){
            return 'A';
        } else if(percentage >= 60){
            return 'B';
        } else if(percentage >= 50){
            return 'C';
        } else if(percentage >= 40){
            return 'D';
        } else {
            return 'F';
        }
    }
    static String calculateResult(char grade){
        return grade != 'F'? "PASS" : "FAIL";
    }
}
