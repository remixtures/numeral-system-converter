package converter;

import java.util.Scanner;

public class ValidateInput {

    public void validation() {
        Scanner input = new Scanner(System.in);
        int sourceRadix = 0;
        if (input.hasNextInt()) {
            sourceRadix = input.nextInt();
        } else {
            System.out.println("error: source radix not provided");
            return;
        }
        if (!validateRadix(sourceRadix)) {
            System.out.println("error: source radix out of valid range");
            return;
        }

        String number;
        if (input.hasNext("[0-9A-Za-z]+(.[0-9A-Za-z]+)?")) {
            number = input.next();
        }   else {
            System.out.println("error: invalid number");
            return;
        }

        int targetRadix = 0;
        if (input.hasNextInt()) {
            targetRadix = input.nextInt();
        } else {
            System.out.println("error: target radix nor provided");
            return;
        }
        if (!validateRadix(targetRadix)) {
            System.out.println("error: target radix out of valid range");
            return;
        }

        NumericalConverter numericalConverter = new NumericalConverter();
        numericalConverter.convert(sourceRadix, number, targetRadix);
    }

    private boolean validateRadix(int radix) {
        return radix >=1 && radix <= 36;
    }
}