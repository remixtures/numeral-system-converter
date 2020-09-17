package converter;

public enum Letter {

    A('a', 10),
    B('b', 11),
    C('c', 12),
    D('d', 13),
    E('e', 14),
    F('f', 15),
    G('g', 16),
    H('h', 17),
    I('i', 18),
    J('j', 19),
    K('k', 20),
    L('l', 21),
    M('m', 22),
    N('n', 23),
    O('o', 24),
    P('p', 25),
    Q('q', 26),
    R('r', 27),
    S('s', 28),
    T('t', 29),
    U('u', 30),
    V('v', 31),
    W('w', 32),
    X('x', 33),
    Y('y', 34),
    Z('z', 35);

    char letter;
    int number;

    /**
     * Each enum object corresponds to a letter of the alphabet and represents a numeric value
     * */
    Letter(char letter, int number) {
        this.letter = letter;
        this.number = number;
    }

    /**
     * Finds the numeric value that is associated with each character of alphabet
     * @param letter takes a alphabetic character as a argument
     * @return returns the numeric value associated with the character
     * */
    public static int findNumericValue(char letter) {
        int n = -1;
        for (Letter value: values()) {
            if (letter == (value.letter)) {
                n = value.number;
            }
        }
        return n;
    }

    /**
     * Finds the character that is associated with the corresponding number  of alphabet
     * @param number takes a numeric value associated with a letter
     * @return returns the letter associated with the number
     * */
    public static char findLiteralValue(int number) {
        char c = ' ';
        for (Letter value: values()) {
            if (number == (value.number)) {
                c = value.letter;
            }
        }
        return c;
    }
}