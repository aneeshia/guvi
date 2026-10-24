package Daily.Day6;

public class Homework_Problem3 {
    public static void main(String[] args) {
        /**
         * ===========================================================
         * Problem 3: Bank Account Management System
         * ============================================================
         * Problem Statement
         * Create a simple bank account program.
         *
         * The program should maintain:
         * Account Number
         * Account Holder Name
         * Balance
         *
         * The program should support deposit, withdrawal and account information display.
         *
         * Required Methods
         * static double deposit(double balance, double amount)
         * static double withdraw(double balance, double amount)
         * static boolean canWithdraw(double balance, double amount)
         * static void displayAccount(String accountNumber,String name,double balance)
         *
         *
         * Method Overloading:
         * Create another version of displayAccount():
         * static void displayAccount(String accountNumber,String name)
         *
         * This version should display account information without displaying the balance.
         *
         * Rules
         * Deposit amount must be greater than zero.
         * Withdrawal amount must be greater than zero.
         * Withdrawal should not be allowed if the balance is insufficient.
         * Keep calculation logic and display logic in separate methods.
         *
         * Sample Input
         * Account Number: ACC101
         * Name: Rahul
         * Initial Balance: 25000
         * Deposit: 5000
         * Withdrawal: 8000
         *
         * Sample Output
         * Account Number: ACC101
         * Account Holder: Rahul
         * Final Balance: 22000
         */
        String accNum = "ACC101";
        String name = "Rahul";
        double initialBalance = 25000;
        double depositAmt = 5000;
        double withdrawalAmt = 8000;
        double finalBalance = deposit(initialBalance, depositAmt);
        finalBalance = withdraw(finalBalance, withdrawalAmt);

        displayAccount(accNum, name, finalBalance);
        displayAccount(accNum,name);
        System.out.println(finalBalance);
    }

    static double deposit(double balance, double amount) {
        if(amount <= 0) return balance;
        return balance + amount;
    }
    static double withdraw(double balance, double amount) {
        if(canWithdraw(balance,amount)) return balance;
        return balance - amount;
    }
    static boolean canWithdraw(double balance, double amount) {
        if(amount <=0) {
            System.out.println("Withdrawal amount must be greater than zero");
            return false;
        }
        if(balance-amount < 0) {
            System.out.println("Withdrawal not allowed. Your balance is insufficient");
            return false;
        }
        return true;
    }
    static void displayAccount(String accountNumber,String name,double balance){
        System.out.println("""
        ===== OUTPUT =====
        
        Account Number: %s
        Account Holder: %s
        Final Balance: %.2f
        """.formatted(
                accountNumber,
                name,
                balance
        ));
    }

    static void displayAccount(String accountNumber,String name){
        System.out.println("""
        ===== OUTPUT =====
        
        Account Number: %s
        Account Holder: %s
        """.formatted(
                accountNumber,
                name
        ));
    }
}
