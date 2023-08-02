import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Please enter your identity number's top 9 digit: ");
        Scanner input = new Scanner(System.in);
        long identity = input.nextLong();
        if (validity(identity)){
            int[]result = calculation(identity);
            System.out.println("The last 2 digits are: " + Arrays.toString(result));
        } else {
            System.out.println("Invalid Input!");
        }

    }

    public static boolean validity (long identity) {
        return (identity > Math.pow(10, 8) && identity < Math.pow(10, 9));
    }

    public static int[] calculation (long identity) {
        int total1 = 0;
        int total2 = 0;
        int i = 9;
        int j = 8;
        while (i >= 1) {
            int loop1 = (int) (identity % Math.pow(10, i) / Math.pow(10, (i - 1)));
            total1 = total1 + loop1;
            i = i-2;
        }
        while (j >= 1) {
            int loop2 = (int) (identity % Math.pow(10, j) / Math.pow(10, (j - 1)));
            total2 = total2 + loop2;
            j = j-2;
        }
        int tenth = (total1 * 7 - total2) % 10;
        int eleventh = (total1 + total2 + tenth) % 10;
        return new int[]{tenth, eleventh};
    }
}