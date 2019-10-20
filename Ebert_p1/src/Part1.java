import java.util.Scanner;
import java.security.SecureRandom;

public class Part1 {
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
                System.out.println("Very Good!");
                System.out.print("Continue (y/n)? ");
                contResponse = scnr.next();
            } else {
                while (Math.abs(answer - (num1 * num2)) > 0.0001) {
                    System.out.print("No. Please try again. ");
                    answer = scnr.nextDouble();
                    if (Math.abs(answer - (num1 * num2)) < 0.0001) {
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

}
