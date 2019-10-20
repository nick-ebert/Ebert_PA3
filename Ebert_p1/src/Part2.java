import java.security.SecureRandom;
import java.util.Scanner;

public class Part2 {
    private static int num1;
    private static int num2;

    public static void main(String [] args) {
        double answer;
        String contResponse = "";

        Scanner scnr = new Scanner(System.in);

        do {
            generateQuestion();
            answer = scnr.nextDouble();

            if (Math.abs(answer - (num1 * num2)) < 0.0001) {
                generatePositiveResponse();
                System.out.print("Continue (y/n)? ");
                contResponse = scnr.next();
            } else {
                while (Math.abs(answer - (num1 * num2)) > 0.0001) {
                    generateNegativeResponse();
                    answer = scnr.nextDouble();
                    if (Math.abs(answer - (num1 * num2)) < 0.0001) {
                        generatePositiveResponse();
                        System.out.print("Continue (y/n)? ");
                        contResponse = scnr.next();
                        break;
                    }
                }
            }
        } while (contResponse.compareTo("y") == 0);
    }

    public static void generateQuestion(){
        SecureRandom rand = new SecureRandom();
        num1 = rand.nextInt(10);
        num2 = rand.nextInt(10);
        System.out.printf("How much is %d times %d? ", num1, num2);

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
                System.out.print("No. Please try again. ");
                break;
            case 1:
                System.out.print("Wrong. Try once more. ");
                break;
            case 2:
                System.out.print("Don't give up. ");
                break;
            case 3:
                System.out.print("No. Keep trying. ");
        }
    }
}
