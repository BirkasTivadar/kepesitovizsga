package hu.nive.ujratervezes.kepesitovizsga.adddigits;

public class AddDigits {

    public int addDigits(String input) {
        if (isEmpty(input)) {
            return -1;
        }

        int sum = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Integer.parseInt(String.valueOf(c));
            }
        }

        return sum;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isBlank();
    }

}
