class SpringSeason {
    public static void main(String[] args) {

        // Read month and day from command line
        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        // Check spring season
        boolean isSpring = checkSpringSeason(month, day);

        // Display result
        if (isSpring) {
            System.out.println("Its a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    // Method to check Spring Season
    public static boolean checkSpringSeason(int month, int day) {

        // Spring: March 20 to June 20
        if ((month == 3 && day >= 20) || (month == 4) || (month == 5) || (month == 6 && day <= 20)) {
            return true;
        }
        return false;
    }
}