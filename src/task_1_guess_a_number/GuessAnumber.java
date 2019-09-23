package task_1_guess_a_number;

import java.util.Random;
import java.util.Scanner;

public class GuessAnumber {

    public static void main(String[] args) {

        Random rand = new Random();

        int randomInt = rand.nextInt(100) + 1;

        int counter = 0;

        String notInRangeInt = "This in not an integer from the specified range. Try again.";

        System.out.println("Welcome to guess-my-integer game!\n\n" +
                "Here are the rules:\nI have picked an integer ranging from 1 to 100.\n" +
                "You have to guess the integer. Every time you try, I will give you a hint.\n" +
                "Good luck!\n\n" +
                "What is my integer?");

        Scanner scan = new Scanner(System.in);

        String guessString = scan.next();
        counter++;

        while (!guessString.equals(randomInt)) {

            while (!isInteger(guessString) || !isInRange(guessString)) {

                System.out.println(notInRangeInt);
                guessString = scan.next();
                counter++;

            }

            int guessInt = Integer.parseInt(guessString);

            if (guessInt < randomInt) {

                System.out.println("My number is greater. Try again.");
                guessString = scan.next();
                counter++;

            } else if (guessInt > randomInt) {

                System.out.println("My number is lesser. Try again.");
                guessString = scan.next();
                counter++;

            } else {

                break;
            }
        }
        scan.close();

        System.out.println("Congratulations! You have guessed my number. It is indeed " + randomInt + ".\n" +
                "It took you " + counter + " turns.");
        System.out.println("GAME OVER");

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isInRange(String s) {
        try {
            Integer number = Integer.parseInt(s);
            if (number >= 1 && number <= 100) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

}