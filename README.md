A text-based mathematical helper application built in Java. The program converts any kind of number (both integers and fractionals) from one numeral system to another, according to its base (radix). The later can range from 1 to 36. Among the most popular numeral systems it can convert from and to are: 

- binary (base 2): made of 0s and 1s, each digit represents a bit;
- octal (base 8): made of eight numbers (0, 1, 2, 3, 4, 5, 6, 7);
- decimal (base 10): made of ten numbers (0, 1, 2, 3, 4, 5, 6, 7, 8, 9). This is the conventional numeral system used nowadays by most humans that was originally introduced in medieval times by the Arabs;
- hexadecimal (base 16 or hex): made of 16 symbols - 0 to 9 are used to represent values from zero to nine while "A"–"F" (or alternatively "a"–"f") represent values ten to fifteen.

Apart from integers, the program also allows the user to convert fractional numbers in between two differente base systems. 
In order to execute it, the user needs to enter three symbols, each in a different line: 

- the number representing the source radix;
- the symbol representing the source number;
- the number representing the target radix. 

If any one of the inputs entered by the user is not validated by the program (for instance, if one of the numbers representing a radix goes beyond the accepted number range - from 1 to 36 - or if the symbol representing the number can not be converted to the given radix), the user is presented with an error message

Example 1:

Input:

10
0.234
7

Output:

0.14315

Example 2:

Input:

10
10.234
7

Output:

13.14315

Example 3:

Input:

35
af.xy
17

Output:

148.g88a8

Example 4:

Input:

16
aaaaa.0
24

Output:

22df2.00000

Example 5:

Input:

21
4242
6

Output:

451552

Example 6:

Input:

1
1111111
10

Output:

7