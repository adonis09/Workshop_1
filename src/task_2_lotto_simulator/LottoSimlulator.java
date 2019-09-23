package task_2_lotto_simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoSimlulator {

    public static void main(String[] args) {
        System.out.println("Welcome to LOTTO simulator.\nThe program randomly picks 6 numbers, ranging from 1 to 49.\n" +
                "The player chooses his 6 numbers and hopes they match with machine's.\n" +
                "Please type in 6 unique integers ranging from 1 to 49, separated by SPACE and press ENTER");

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] inputSplitted = input.split(" ");

        boolean inputOK = false;

        while (inputOK == false) {

            while (inputSplitted.length != 6) {

                System.out.println("Your input does not consist of 6 elements. Try again.\n" +
                        "Please type in 6 unique integers ranging from 1 to 49, separated by SPACE and press ENTER");
                input = scan.nextLine();
                inputSplitted = input.split(" ");
            }

            int checkCount = 0;
            for (int i = 0; i < 6; i++) {
                if (isInteger(inputSplitted[i]) && isInRange(inputSplitted[i])) {
                    checkCount++;
                }
            }
            if (checkCount < 6) {
                System.out.println("At least one of the elements from your input is not an integer from the specified range. Try again.\n" +
                        "Please type in 6 unique integers ranging from 1 to 49, separated by SPACE and press ENTER");
                input = scan.nextLine();
                inputSplitted = input.split(" ");

            } else {

                if (hasNoDoubles(inputSplitted)) {
                    inputOK = true;
                } else {
                    System.out.println("Integers you input must be unique. Try Again.\n" +
                            "Please type in 6 unique integers ranging from 1 to 49, separated by SPACE and press ENTER");
                    input = scan.nextLine();
                    inputSplitted = input.split(" ");
                }

            }

        }

        scan.close();

        List<Integer> userNumbers = new ArrayList<>();
        for (int i = 0; i < inputSplitted.length; i++) {
            userNumbers.add(Integer.parseInt(inputSplitted[i]));
        }
        Collections.sort(userNumbers);
        System.out.println("Your numbers:\n" + userNumbers);


        List<Integer> allNumbers = new ArrayList<>();

        for (int i = 1; i <= 49; i++) {
            allNumbers.add(i);
        }

        Collections.shuffle(allNumbers);
        List<Integer> pickedNumbers = allNumbers.subList(0, 6);
        Collections.sort(pickedNumbers);

        System.out.println("Picked numbers:\n" + pickedNumbers);

        int hitCount = 0;

        for (int oneUserNumber : userNumbers) {
            for (int onePickedNumber : pickedNumbers) {
                if (oneUserNumber == onePickedNumber) {
                    hitCount++;
                }
            }
        }

        System.out.println("Your score is: " + hitCount + "\nGood luck next time!");

    }

    static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    static boolean isInRange(String s) {
        try {
            Integer number = Integer.parseInt(s);
            if (number >= 1 && number <= 49) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean hasNoDoubles(String[] s) {

        int[] ints = new int[6];
        int doublesCount = 0;

        for (int i = 0; i < s.length; i++) {
            ints[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i] == ints[j]) {
                    doublesCount++;
                }
            }
        }

        if (doublesCount > 6) {
            return false;
        } else {
            return true;
        }

    }

}
