package task_1_guess_a_number;

import java.util.HashMap;
import java.util.Map;
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

                printRandomCoolPrompt(counter);
                System.out.println(notInRangeInt);
                guessString = scan.next();
                counter++;

            }

            int guessInt = Integer.parseInt(guessString);

            if (guessInt < randomInt) {

                printRandomCoolPrompt(counter);
                System.out.println("My number is greater. Try again.");
                guessString = scan.next();
                counter++;

            } else if (guessInt > randomInt) {

                printRandomCoolPrompt(counter);
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

    public static void printRandomCoolPrompt(int count) {

        Random rand = new Random();

        String coolPrompt1 = "Stop trying to hit me and hit me!";
        String coolPrompt2 = "You think it's air that you're breathing now?";
        String coolPrompt3 = "Free your mind.";
        String coolPrompt4 = "You have to let it all go. Fear, doubt, and disbelief.";

        Map<Integer, String> coolPrompts = new HashMap<>();
        coolPrompts.put(1, coolPrompt1);
        coolPrompts.put(2, coolPrompt2);
        coolPrompts.put(3, coolPrompt3);
        coolPrompts.put(4, coolPrompt4);

        if (count % 5 == 0) {
            System.out.println(coolPrompts.get(rand.nextInt(4) + 1));
        }
    }

}