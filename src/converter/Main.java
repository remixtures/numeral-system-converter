package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ValidateInput validator = new ValidateInput();
        validator.validation();

        /*String radix = "^([1-9]|1[0-9]|2[0-9]|3[0-6])$";
        String validFractionalNumber = "^([a-zA-Z0-9]+|([a-zA-Z0-9]+\\.[a-zA-Z0-9]+))$";
        int sourceBase = 0;
        int targetBase = 0;

        *//* Check for a valid source radix *//*
        String srcInput = input.nextLine().trim();
        if (srcInput.matches(radix) && input.hasNextLine()) {
            sourceBase = Integer.parseInt(srcInput);
        } else {
            System.out.println("error - invalid radix (source base)");
            return;
        }
        *//* Check if user has input a valid number for conversion *//*
        String number = input.nextLine().trim();
        if (!number.matches(validFractionalNumber) || !input.hasNextLine()) {
            System.out.println("error");
            return;
        }
        *//* Check for valid target radix *//*
        String targetInput = input.nextLine().trim();
        if (targetInput.matches(radix)) {
            targetBase = Integer.parseInt(targetInput);
        } else {
            System.out.println("error- invalid radix (target)");
            return;
        }

        NumberConverter numConverter = new NumberConverter(number, sourceBase, targetBase);

        *//* the provided number is a fraction *//*
        if (number.matches("^\\s*[a-zA-Z0-9]+\\.[a-zA-Z0-9]+\\s*$")) {
            numConverter.convertFractionNumber();
        } else {
            numConverter.convertNumber();                           // the provided number is a whole number
        }
        System.out.println(numConverter.getConvertedNumber());      // print the converted number*/
    }
}