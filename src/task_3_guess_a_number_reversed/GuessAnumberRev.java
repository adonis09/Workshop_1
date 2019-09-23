package task_3_guess_a_number_reversed;

import java.util.Scanner;

public class GuessAnumberRev {

    public static void main(String[] args) {

        Integer movecount = 0;
        Integer min = 1;
        Integer max = 1000;
        Integer guess = (int) ((max - min) / 2 + min);

        System.out.println("Welcome to I-guess-your-integer game!\n\n" +
                "Here are the rules:\nYou pick an integer ranging from 1 to 1000. Don't tell me!\n" +
                "I have to guess your integer in 10 moves. Every time I try, you will give me a hint.\n" +
                "If your integer is lesser than my guess, please type in \"l\".\n" +
                "If it is greater, please type in \"g\".\n" +
                "Finally, if I guess your integer, please type in \"yes\".\n\n" +

                "Now, pick and integer and let's start the game.");

        String guessMessage = "Is it ";
        System.out.println(guessMessage + guess + "?");

        String wrongInput = ("I don't understand your input. Please type in \"l\" for lesser, \"g\" for greater or \"yes\" if it is your number, and press ENTER.");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.equals(null)) {

            if (input.equals("yes")) {
                System.out.println("aaah yeeeah!");
                movecount++;
                break;
            } else if (input.equals("l")) {
                max = guess;
                movecount++;
                if (min.intValue() == max.intValue()) {
                    System.out.println("You seem to be cheating...");
                    break;
                }

            } else if (input.equals("g")) {
                min = guess;
                movecount++;
                if (min.intValue() == max.intValue()) {
                    System.out.println("You seem to be cheating...");
                    break;
                }
            } else {
                System.out.println(wrongInput);
            }

            guess = (int) ((max - min) / 2 + min);
            System.out.println(guessMessage + guess + " ?");
            input = scan.nextLine();

        }
        scan.close();
        System.out.println("Game is finished in " + movecount + " moves.");
    }

}