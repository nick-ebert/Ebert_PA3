import java.security.SecureRandom;
import java.util.Scanner;

public class Part4 {
    private static int num1;
    private static int num2;


    public static void main(String [] args) {
        double answer;
        int countCorrect = 0;
        int userDifficulty;
        String contResponse = "y";

        Scanner scnr = new Scanner(System.in);
        while(contResponse.compareTo("y") == 0) {
            System.out.print("Enter difficulty level (1-4): ");
            userDifficulty = scnr.nextInt();

            for (int i = 1; i <= 10; i++) {
                setDifficulty(userDifficulty);
                generateQuestion(num1, num2);
                answer = scnr.nextDouble();

                if (Math.abs(answer - (num1 * num2)) < 0.0001) {
                    generatePositiveResponse();
                    countCorrect++;
                } else {
                    generateNegativeResponse();
                }
            }
            if ((countCorrect / 10.0) >= 0.75) {
                System.out.println("Congratulations, you are ready to advance to the next level.");
            } else {
                System.out.println("Please ask your teacher for extra help.");
            }

            System.out.println("Another student (y/n)? ");
            contResponse = scnr.next();
        }

    }

    public static void setDifficulty(int difficulty){
        SecureRandom rand = new SecureRandom();
        switch(difficulty) {
            case 1:
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case 2:
                num1 = rand.nextInt(100 - 10 + 1) + 10;
                num2 = rand.nextInt(100 - 10 + 1) + 10;
                break;
            case 3:
                num1 = rand.nextInt(1000 - 100 + 1) + 100;
                num2 = rand.nextInt(1000 - 100 + 1) + 100;
                break;
            case 4:
                num1 = rand.nextInt(10000 - 1000 + 1) + 1000;
                num2 = rand.nextInt(10000 - 1000 + 1) + 1000;
                break;
        }
    }

    public static void generateQuestion(int firstNum, int secondNum){
        System.out.printf("How much is %d times %d? ", firstNum, secondNum);
    }

    public static void generatePositiveResponse(){
        SecureRandom random = new SecureRandom();
        int selector = random.nextInt(4);
        switch (selector){
            case 0:
                System.out.println("Very good!");
                break;
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Nice work!");
                break;
            case 3:
                System.out.println("Keep up the good work!");
        }
    }

    public static void generateNegativeResponse(){
        SecureRandom random = new SecureRandom();
        int selector = random.nextInt(4);
        switch (selector){
            case 0:
                System.out.println("No. Please check your work carefully.");
                break;
            case 1:
                System.out.println("Wrong. Try the next one.");
                break;
            case 2:
                System.out.println("Don't give up.");
                break;
            case 3:
                System.out.println("No. Keep trying.");
        }
    }
}
