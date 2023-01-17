package ru.job4j.chapter03.factorial;

public class Factorial2 {
    public int getFactorial(int number) {
        if (isZeroOrOne(number)) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }

    public boolean isZeroOrOne(int number) {
        if (number > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Factorial2 factorial2 = new Factorial2();
        System.out.println("The factorial of 6 is " + factorial2.getFactorial(6));
    }
}
