package converter;

import java.util.Arrays;

public class NumberConverter {

    private int sourceBase;
    private String number;
    private int targetBase;
    private StringBuilder convertedNumber = new StringBuilder();

    public NumberConverter(String number, int sourceBase, int targetBase) {
        this.number = number;
        this.sourceBase = sourceBase;
        this.targetBase = targetBase;
    }
    /**
     * Function which converts a fraction from a source radix to a target radix. To convert any number, first each
     * number will be split into two portions 1) integer and 2) fractional and then converted to target radix
     * Example: 10.2344 --> Integer = 10, Fractional = 0.2344
     * */
    public void convertFractionNumber() {

        /* if the fraction is provided in decimal format */
        if (sourceBase == 10) {
            /* split the fraction into integer apart nd fractional part */
            int integerValue = (int) Double.parseDouble(number);
            double value = Double.parseDouble(number);
            value -= integerValue;

            convertDecimalToTarget(integerValue);   // call function to convert integer portion to desired format

            this.convertedNumber.append('.');
            convertFractionalPart(value);           // call function to convert the fractional portion of number

        } else {    // source number is not in decimal format so first will need to convert from source radix to decimal base (10)

            String[] splitNum = number.split("\\.");
            int integerPart = convertSourceToDecimal(splitNum[0]); //integer part of number

            if (targetBase == 1) {
                convertDecimalToTarget(integerPart);
            } else { // any other target base
                convertDecimalToTarget(integerPart);
                this.convertedNumber.append('.');

                /* convert fractional to decimal */
                double decimalValue = 0;
                /* iterate over the fractional portion */
                for (int i = 0; i < splitNum[1].length(); i++) {
                    int currValue = 0;

                    if (Character.isDigit(splitNum[1].charAt(i))) {
                        currValue = Character.digit(splitNum[1].charAt(i), 10);
                    } else { //if the character in fractional part is a letter then get it's numeric value
                        currValue = Letter.findNumericValue(splitNum[1].charAt(i));
                    }

                    /* formula which gives you the fractional value in decimal format */
                    decimalValue += (double) currValue / (Math.pow(sourceBase, i + 1));
                }
                convertFractionalPart(decimalValue);
            }
        }
    }

    /**
     * Converts the fractional part of a number to the desired format
     * @param value the fraction value
     * */
    public void convertFractionalPart(double value) {
        double var = value;
        /* the converted value to 5 decimal places  */
        for (int i = 0; i < 5; i++) {
            var  = var * targetBase;        // multiply the target radix with value each time
            int temp = (int) var;           // take the integer portion of calculated value to be appended

            /* Append the value to the StringBuilder object. If it's a literal, append the corresponding value */
            if (temp <= 9) {
                this.convertedNumber.append(temp);
            } else {
                char c = Letter.findLiteralValue(temp);
                this.convertedNumber.append(c);
            }
            var -= temp;                  // remove integer part for next iteration

        }
    }

    /**
     * Converts the number to the decimal numeric system
     * @param number takes the string representation of the number as an argument
     * @return the converted decimal number
     * */
    public int convertSourceToDecimal(String number) {
        int decimalNum;

        /* if the source radix is already decimal then just parse the string as an int */
        if (sourceBase == 10) {
            decimalNum = Integer.parseInt(number);
        } else if (sourceBase == 1) { // source radix is 1 then return the length of the string
            decimalNum = number.length();
        } else { // for any other base parse using function from java API
            decimalNum = Integer.parseInt(number, sourceBase);
        }
        return decimalNum;
    }

    /**
     * Converts a whole number to the target radix
     * */
    public void convertNumber() {

        /* Calls the function to convert the source to decimal first */
        int decimalNum = convertSourceToDecimal(this.number);
        convertDecimalToTarget(decimalNum);         // convert the decimal number to target radix
    }

    /**
     * Converts the number in decimal format to the target radix
     * @param decimalNum takes the decimal number as a argument for conversion
     * */
    public void convertDecimalToTarget(int decimalNum) {
        if (targetBase == 1) {          // the targeted radix is 1
            int[] oneBaseNum = new int[decimalNum];
            /* Fill the array with desired number of 1's */
            Arrays.fill(oneBaseNum, 1);
            String str = Arrays.toString(oneBaseNum).
                    replace("[", "").
                    replace("]", "").
                    replaceAll(", ", "");
            /* append the converted number to the StringBuilder object */
            this.convertedNumber.append(str);
        } else { // the target radix is a different format
            String str = Integer.toString(decimalNum, targetBase);
            this.convertedNumber.append(str == null ? "0" : str); // null check in case of fraction number
        }
    }

    /**
     * Returns the converted number to be displayed
     * @return the converted number as a StringBuilder object
     * */
    public StringBuilder getConvertedNumber() {
        return convertedNumber;
    }
}