public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate = 0.0;

    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance(){
        return savingsBalance;
    }

    public double calculateMonthlyInterestRate(double savingsBalance, double annualInterestRate){
        return (savingsBalance * annualInterestRate / 12.0);
    }

    public double updateSavingsBalance(double monthlyInterest){
        this.savingsBalance += monthlyInterest;
        return this.savingsBalance;
    }

    public static double modifyInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate / 100;
        return annualInterestRate;
    }
}
