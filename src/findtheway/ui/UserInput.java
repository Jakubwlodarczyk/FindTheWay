package findtheway.ui;

import java.util.Scanner;

public class UserInput {

    public static String getUserStringInput() {
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static Integer getUserIntegerInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
