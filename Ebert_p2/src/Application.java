public class Application {
    public static void main(String [] args){
        double monthlyInterest1;
        double monthlyInterest2;
        double savingsBalance1;
        double savingsBalance2;
        double annualInterestRate;


        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

       annualInterestRate = SavingsAccount.modifyInterestRate(4);

       for(int i = 1; i <= 12; i++){
           savingsBalance1 = saver1.getSavingsBalance();
           savingsBalance2 = saver2.getSavingsBalance();

           monthlyInterest1 = saver1.calculateMonthlyInterestRate(savingsBalance1, annualInterestRate);
           monthlyInterest2 = saver2.calculateMonthlyInterestRate(savingsBalance2, annualInterestRate);

           saver1.updateSavingsBalance(monthlyInterest1);
           saver2.updateSavingsBalance(monthlyInterest2);
       }

       System.out.printf("Saver 1 balance after 1 year with annual interest rate of %.0f: $%.2f%n", annualInterestRate * 100, saver1.getSavingsBalance());
       System.out.printf("Saver 2 balance after 1 year with annual interest rate of %.0f: $%.2f%n", annualInterestRate * 100, saver2.getSavingsBalance());

       annualInterestRate = SavingsAccount.modifyInterestRate(5);
       monthlyInterest1 = saver1.calculateMonthlyInterestRate(saver1.getSavingsBalance(), annualInterestRate);
       monthlyInterest2 = saver2.calculateMonthlyInterestRate(saver2.getSavingsBalance(), annualInterestRate);
       saver1.updateSavingsBalance(monthlyInterest1);
       saver2.updateSavingsBalance(monthlyInterest2);

       System.out.printf("Saver 1's next month balance with annual interest rate of %.0f: $%.2f%n", annualInterestRate * 100, saver1.getSavingsBalance());
       System.out.printf("Saver 2's next month balance with annual interest rate of %.0f: $%.2f%n", annualInterestRate * 100, saver2.getSavingsBalance());

    }
}
