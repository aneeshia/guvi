package Daily.Day15;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(6));
        System.out.println(printFibonacci(0,1,7));
        System.out.println(factorial(5));
        System.out.println(print1toN(8, 1));
    }
    public static int fibonacci(int n) {
        if(n<=1) {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static boolean printFibonacci(int a, int b, int count) {
        if (count == 0) {
            return false;
        }

        System.out.print(a + " ");
        printFibonacci(b, a + b, count - 1);
        return false;
    }

    public static int factorial(int n) {
        if(n == 1){
            return  n;
        }
        System.out.println("Before\t : "+ n);
        int result = n * factorial(n -1);
        System.out.println("After\t : " + n + " * " + (n-1) + " = " + result);
        return result;
    }
    public static boolean print1toN(int target, int n){
        if(target == n) {
            return false;
        }
        System.out.println(n);
        print1toN(target, n + 1);
        return false;
    }
}
