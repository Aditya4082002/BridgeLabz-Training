package DSA;

class CircularTour {

    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartingPoint(PetrolPump[] pumps) {
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;

            // If surplus becomes negative, reset start
            if (surplus < 0) {
                deficit += surplus;
                surplus = 0;
                start = i + 1;
            }
        }

        // Check if total petrol is sufficient
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {

        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int start = findStartingPoint(pumps);

        if (start == -1)
            System.out.println("No possible circular tour");
        else
            System.out.println("Start at petrol pump index: " + start);
    }
}

