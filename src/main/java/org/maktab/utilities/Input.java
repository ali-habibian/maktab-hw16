package org.maktab.utilities;

import java.util.Scanner;

public class Input {
    static Scanner input = new Scanner(System.in);

    public static String getOptionalStringInputValue(String msg) {
        System.out.print(Color.MAGENTA);
        System.out.print(msg + " ");
        System.out.print(Color.RESET);
        return input.nextLine().trim();
    }

    public static String getStringInputValue(String msg) {
        String result = null;
        while (true) {
            result = getOptionalStringInputValue(msg);
            if (result.isEmpty())
                Printer.printErrorMessage("Invalid input!");
            else
                return result;
        }
    }

    public static int getIntInputValue(String msg) {
        while (true)
            try {
                return Integer.parseInt(getStringInputValue(msg));
            } catch (Exception e) {
                Printer.printErrorMessage("Invalid input!");
                if (msg.isEmpty())
                    System.out.print(">> ");
            }
    }

    public static double getDoubleInputValue(String msg) {
        while (true)
            try {
                return Double.parseDouble(getStringInputValue(msg));
            } catch (Exception e) {
                Printer.printErrorMessage("Invalid input!");
                if (msg.isEmpty())
                    System.out.print(">> ");
            }
    }

    public static long getLongInputValue(String msg) {
        while (true)
            try {
                return Long.parseLong(getStringInputValue(msg));
            } catch (Exception e) {
                Printer.printErrorMessage("Invalid input!");
                if (msg.isEmpty())
                    System.out.print(">> ");
            }
    }
}
