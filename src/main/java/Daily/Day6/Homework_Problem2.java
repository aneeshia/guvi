package Daily.Day6;

import java.math.BigInteger;

public class Homework_Problem2 {
    public static void main(String[] args) {
        /**
         * =================================================================
         * Problem 2: Recursive Number Analyzer
         * =================================================================
         * Problem Statement
         *
         * Write a Java program that performs different operations on a positive integer.
         * The following operations must be implemented using recursion:
         *
         * Sum of digits
         * Number of digits
         * Reverse of the number
         * Factorial
         *
         * Required Methods
         * static int sumOfDigits(int n)
         * static int countDigits(int n)
         * static int reverseNumber(int n, int result)
         * static long factorial(int n)
         *
         * Requirements
         * Do not use loops for these four operations.
         * Every recursive method must have a proper base condition.
         * Identify the base condition for each method.
         * Understand what would happen if the base condition were removed.
         *
         * Sample Input
         * Number: 1234
         *
         * Sample Output
         * Sum of digits: 10
         * Number of digits: 4
         * Reverse: 4321
         * Factorial: 24
         */
        int number = 1234;
        int sum = sumOfDigits(number);
        int count = countDigits(number);
        int reverse = reverseNumber(number, 0);
        int factorialV  = factorial(3);
        BigInteger factorialBigIntV = factorialBigInt(number);
        System.out.println("""
        ===== OUTPUT =====
        
        Number: %d
        Sum of digits: %d
        Number of digits: %d
        Reverse: %d
        Factorial: %d
        FactorialBigInteger: %d
        """.formatted(
                number,
                sum,
                count,
                reverse,
                factorialV,
                factorialBigIntV
        ));
    }
    static int sumOfDigits(int number){
        int digit = number % 10;
        if(digit == 0) {
            return 0;
        }
        return digit + sumOfDigits(number/10);
    }
    static int countDigits(int number){
        int digit = number % 10;
        if(digit == 0) {
            return 0;
        }
        return 1 + countDigits(number/10);
    }
    static int reverseNumber(int number, int result){
        if(number == 0) {
            return result;
        }
        int digit = number % 10;
        int nextNumber = number/10;
        result = result * 10 + digit;
        return reverseNumber(nextNumber, result);
    }
    static int factorial(int number){
        if(number <= 1) {
            return 1;
        }
        return number * factorial(number-1);
    }
//
    static BigInteger factorialBigInt(int number){
        if(number <= 1) {
            return BigInteger.ONE;
        }
//        return number * factorialBigInt(number-1);
        return BigInteger.valueOf(number)
                .multiply(factorialBigInt(number - 1));
    }

}
