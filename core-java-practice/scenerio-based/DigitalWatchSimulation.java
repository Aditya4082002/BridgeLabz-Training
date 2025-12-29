public class DigitalWatchSimulation {

    public static void main(String[] args) {

        System.out.println("Digital Watch Simulation Started");

        // Loop for hours (0 to 23 for 24-hour format)
        for (int hour = 0; hour < 24; hour++) {

            // Loop for minutes (0 to 59)
            for (int minute = 0; minute < 60; minute++) {

                // Simulate power cut at 13:00
                if (hour == 13) {
                    System.out.println("Power cut at 13:00! Watch stopped.");
                    break; // Exit minute loop
                }

                // Print time in HH:MM format
                System.out.printf("%02d:%02d%n", hour, minute);
            }

            // Exit hour loop after power cut
            if (hour == 13) {
                break;
            }
        }

        System.out.println("Simulation Ended");
    }
}
