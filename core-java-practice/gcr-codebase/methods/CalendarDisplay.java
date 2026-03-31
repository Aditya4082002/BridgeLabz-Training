//Program to display a calendar for a given month and year
import java.util.Scanner;

class CalendarDisplay {
    public static void main(String[] args) {
        //create scanner object
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter year: ");
        int year = input.nextInt();

        String monthName = getMonthName(month);
        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        // Display calendar
        System.out.println("\t" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }

        // Print dates
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
        //close scanner stream
        input.close();
    }

    // Method to get month name
    public static String getMonthName(int month) {

        String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
        };

        return months[month - 1];
    }

    // Method to get number of days in month
    public static int getDaysInMonth(int month, int year) {

        int[] days = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        // February and leap year
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    // Method to check leap year
    public static boolean isLeapYear(int year) {

        if (year % 400 == 0){
            return true;
        }else if (year % 100 == 0){
            return false;
        }else{
            return year % 4 == 0;
        }
    }

    // Method to find first day of month using Gregorian algorithm
    public static int getFirstDayOfMonth(int m, int y) {

        int d = 1;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        return d0;
    }
}
