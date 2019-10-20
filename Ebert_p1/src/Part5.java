import java.security.SecureRandom;
import java.util.Scanner;

public class Part5 {
    private static int num1;
    private static int num2;


    public static void main(String [] args) {
        double answer;
        int countCorrect = 0;
        int userDifficulty;
        int userArithmeticStyle;
        String contResponse = "y";
        String operation = "";

        Scanner scnr = new Scanner(System.in);
        while(contResponse.compareTo("y") == 0) {
            System.out.print("Enter difficulty level (1-4): ");
            userDifficulty = scnr.nextInt();

            System.out.print("Enter arithmetic style (1-5): ");
            userArithmeticStyle = scnr.nextInt();

            for (int i = 1; i <= 10; i++) {
                setDifficulty(userDifficulty);

                SecureRandom random = new SecureRandom();
                int randomOperator = random.nextInt(4) + 1;

                if(userArithmeticStyle < 5){
                    operation = setArithmetic(userArithmeticStyle);
                } else {
                    operation = setArithmetic(randomOperator);
                }

                generateQuestion(num1, num2, operation);
                answer = scnr.nextDouble();


                if(operation.equals("plus")){
                    if (Math.abs(answer - (num1 + num2)) < 0.0001) {
                        generatePositiveResponse();
                        countCorrect++;
                    } else {
                        generateNegativeResponse();
                    }
                } else if(operation.equals("minus")){
                    if (Math.abs(Math.abs(answer) - Math.abs(num1 - num2)) < 0.0001) {
                        generatePositiveResponse();
                        countCorrect++;
                    } else {
                        generateNegativeResponse();
                    }
                } else if(operation.equals("times")){
                    if (Math.abs(answer - (num1 * num2)) < 0.0001) {
                        generatePositiveResponse();
                        countCorrect++;
                    } else {
                        generateNegativeResponse();
                    }
                } else{
                    if (Math.abs(answer - ((double)num1 / num2)) < 0.0001) {
                        generatePositiveResponse();
                        countCorrect++;
                    } else {
                        generateNegativeResponse();
                    }
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

    public static String setArithmetic(int style){

        String operator = "";
        switch(style){
            case 1:
                operator = "plus";
                break;
            case 2:
                operator = "times";
                break;
            case 3:
                operator = "minus";
                break;
            case 4:
                operator = "divided by";
                break;

        }
        return operator;
    }

    public static void generateQuestion(int firstNum, int secondNum, String operator){
        if((secondNum == 0) && (operator.equals("divided by"))){
            secondNum++;
        }
        System.out.printf("How much is %d %s %d? ", firstNum, operator, secondNum);
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
