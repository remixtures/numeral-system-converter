package converter;

public class NumericalConverter {

    private int sourceBase;
    private String initialNumber;
    private int targetBase;
    private String[] symbols = "0123456789abcdefghijklmnopqrstuvwxyz".split("");

    public void convert(int sourceBase, String initialNumber, int targetBase) {
        this.sourceBase = sourceBase;
        this.initialNumber = initialNumber;
        this.targetBase = targetBase;

        if (initialNumber.contains(".")) {
            String[] parts = initialNumber.split("\\.");
            int integerPartInDecimal = integerToDecimal(parts[0]);
            double fractionPartInDecimal = fractionToDecimal(parts[1]);

            String integerPartInBase = integerDecimalToBase(integerPartInDecimal);
            String fractionalPartInBase = fractionDecimalToBase(fractionPartInDecimal);
            System.out.println(integerPartInBase + "." + fractionalPartInBase);
        } else {
            int integer = integerToDecimal(initialNumber);
            String inBase = integerDecimalToBase(integer);
            System.out.println(inBase);
        }
    }

    private String fractionDecimalToBase(double fractionPart) {
        String result = "";
        double product = fractionPart;
        for (int i = 0; i < 5; i++) {
            product *= targetBase;
            String productAsString = String.valueOf(product);
            String[] parts = productAsString.split("\\.");
            int integerToResult = Integer.parseInt(parts[0]);
            String integerToResultAsString = characterToNumber(integerToResult);
            result += integerToResultAsString;
            product -= integerToResult;
        }
        return result;
    }

    private String integerDecimalToBase(int integerPart) {
        String result = "";
        if (targetBase == 1) {
            for (int i = 0; i < integerPart; i++) {
                result += "1";
            }
            return result;
        }
        return Integer.toString(integerPart, targetBase);
    }

    private double fractionToDecimal(String fractionPart) {
        double result = 0.0;
        double divisor = sourceBase;
        double dividend = 0.0;
        for (int i = 0; i < fractionPart.length(); i++) {
            dividend = numberToCharacter(String.valueOf(fractionPart.charAt(i)));
            result += dividend / divisor;
            divisor *= sourceBase;
        }
        return result;
    }

    private int integerToDecimal(String integerPart) {
        if (sourceBase == 1) {
            return integerPart.length();
        }
        return Integer.parseInt(integerPart, sourceBase);
    }

    private int numberToCharacter(String character) {
        String characterLowerCase = character.toLowerCase();
        int[] numbers = new int[36];
        for (int i = 0; i < 36; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < 36; i++) {
            if (symbols[i].equals(characterLowerCase)) {
                return numbers[i];
            }
        }
        return -1;
    }

    private String characterToNumber(int number) {
        return symbols[number];
    }
}