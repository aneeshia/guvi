package Daily.Day4;

public class Homework {
    public static void main(String[] args) {
        System.out.println("\nHomeWork 1 ===================================================");
        int i = 1;
        int evenCount = 0;
        int oddCount = 0;
        int evenSum = 0;
        int oddSum = 0;
        do {
            if(i % 2 == 0){
                evenCount++;
                evenSum +=i;
            } else {
                oddCount++;
                oddSum +=i;
            }
            i++;
        } while (i <= 100);
        System.out.println("OUTPUT Count even & odd from 1 to 100 \tevenCount: "+evenCount + "\t oddCount: "+oddCount);
        System.out.println("OUTPUT Sum even & odd from 1 to 100 \tevenSum: "+evenSum + "\t oddSum: "+oddSum);

        System.out.println();
        System.out.println("HomeWork 2 ===================================================");

        int digitN = 1234567;
        int digitCount = 0;
        int digitSum = 0;
        i = digitN;
        while(i > 0) {
            digitSum += i % 10;
            digitCount++;
            i/=10;
        }
        System.out.println("OUTPUT Count all digits of an integer ["+digitN+"]:\n\tdigitCount: "+digitCount + "\t digitSum: "+digitSum);

        System.out.println();
        System.out.println("HomeWork 3 ===================================================");

        i = 1;
        int multiplicationNumber = 7;
        System.out.println("OUTPUT Multiplication table of " + multiplicationNumber);
        for (; i <= 10; i++) {
            System.out.println("7 * "+ i + " = "+ (i * multiplicationNumber));
        }
        System.out.println();
        System.out.println("HomeWork 4 ===================================================");

        int numToReverse = 1234567;
        int reversed = 0;
        i = numToReverse;
        do {
            reversed = reversed * 10 + i % 10;
            i /= 10;
        } while(i > 0);
        System.out.println("OUTPUT Reverse of "+numToReverse+" is " + reversed);

        System.out.println();
        System.out.println("HomeWork 5 ===================================================");

        int number = 5;
        i = 1;
        System.out.println("OUTPUT Print 1 to N and N to 1 both together, where N: "+number);
        for (int j = number; j >0; i++, j--) {
            System.out.println(i + "\t\t|\t\t" + j);
        }
        System.out.println();
    }
}
