package romeNumbers;

/**
 * Created by Степан on 25.05.2015.
 */
public class RomeNumbers {
    public static String convert(int number) {
        if (number == 100) return "C";
        String result = "";
        String r = "";
        int i = 1;
        if (number >= 50) {
            result = "L";
            r = "L";
            number = number - 50;
        }
        final int t = 5;
        String[] data = new String[2];
        data[0] = "IV";
        data[1] = "IX";
        while (i <= number) {
            result = result + "I";
            for (int j = 0; j <= 10; j++) {
                if (i == 4 + j * t) {
                    result = r + data[j % 2];
                    data[j % 2] = "X" + data[j % 2];

                    if (i >= 44) {
                        result = result.replaceAll("XXXX", "XL");
                    }
                }

            }

            if ((i % 5 == 0) && (i % 40 != 0)) {
                result = getString(result);
            }

            if (i >= 40) {
                result = getString2(result);
                result = getString3(result);
            }

            i++;
        }
        return result;
    }

    private static String getString(String result) {
        result = result.replaceAll("I", "");
        return result;
    }

    private static String getString2(String result) {
        result = result.replaceAll("XXIXI", "L");
        return result;
    }

    private static String getString3(String result) {
        result = result.replaceAll("LXL", "XC");
        return result;
    }

}
