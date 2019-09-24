package task_4_dice_simulator;

import java.util.Random;
import java.util.Scanner;

public class DiceSimulator {

    public static void main(String[] args) {

        System.out.println("Wellcome to dice simulator!\n" +
                "Program accepts code pattern \"xDy+z\", where:\n" +
                "\"y\" is a type of dice (eg. D6, D20),\n" +
                "\"x\" is a number of throws (skip, if you want just one throw),\n" +
                "\"z\" optional modifier (eg. +10, -3).\n" +
                "This program supports the following dice:\n" +
                "D2, D3, D4, D6, D8, D10, D12, D20, D100\n" +
                "Please input your requested dice throw following pattern \"xDy+z\" and press ENTER");

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        while (!input.matches("\\d*D(2|3|4|6|8|10|12|20|100)((\\+|\\-)\\d+)?")) {
            System.out.println("I do not recognize your input. Try again.\n" +
                    "Please input your requested dice throw following pattern \"xDy+z\" and press ENTER");
            input = scan.nextLine();
        }
        scan.close();

        int indexOfD = input.indexOf('D');
        int indexOfModAdd = input.indexOf('+');
        int indexOfModSub = input.indexOf('-');

        String throwsCount = "1";
        String modifier = "0";

        if (indexOfD != 0) {
            throwsCount = input.substring(0, indexOfD);
        }

        if (input.contains("+")) {
            modifier = input.substring(indexOfModAdd);
        }

        if (input.contains("-")) {
            modifier = input.substring(indexOfModSub);
        }

        Integer throwsCountInt = 1;
        Integer modifierInt = 0;

        try {
            throwsCountInt = Integer.parseInt(throwsCount);
            modifierInt = Integer.parseInt(modifier);
        } catch (NumberFormatException e) {

        }

        Integer result;

        Random random = new Random();

        if (input.matches("\\d*D2((\\+|\\-)\\d+)?")) {

            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(2) + 1;
            }
            result = throwsSum + modifierInt;

        }
        if (input.matches("\\d*D3((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(3) + 1;
            }
            result = throwsSum + modifierInt;

        } else if (input.matches("\\d*D4((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(4) + 1;
            }
            result = throwsSum + modifierInt;

        } else if (input.matches("\\d*D6((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(6) + 1;
            }
            result = throwsSum + modifierInt;

        } else if (input.matches("\\d*D8((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(8) + 1;
            }
            result = throwsSum + modifierInt;

        } else if (input.matches("\\d*D10((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(10) + 1;
            }
            result = throwsSum + modifierInt;

        } else if (input.matches("\\d*D20((\\+|\\-)\\d+)?")) {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(20) + 1;
            }
            result = throwsSum + modifierInt;

        } else {
            int throwsSum = 0;
            for (int i = 1; i <= throwsCountInt; i++) {
                throwsSum += random.nextInt(100) + 1;
            }
            result = throwsSum + modifierInt;

        }

        System.out.println("Result of the dice throw is: " + result);

    }

}
