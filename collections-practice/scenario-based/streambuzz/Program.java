package scenario.streambuzz;

import java.util.*;

public class Program {

    public void registerCreator(CreatorStats record) {
        CreatorStats.engagementBoard.add(record);
    }

    public Map<String, Integer> getTopPostCounts(
            List<CreatorStats> records, double likeThreshold) {

        Map<String, Integer> result = new HashMap<>();

        for (CreatorStats creator : records) {
            int count = 0;

            for (double likes : creator.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {
                result.put(creator.getCreatorName(), count);
            }
        }

        return result;
    }

    public double calculateAverageLikes() {

        double sum = 0;
        int totalWeeks = 0;

        for (CreatorStats creator : CreatorStats.engagementBoard) {
            for (double likes : creator.getWeeklyLikes()) {
                sum += likes;
                totalWeeks++;
            }
        }

        if (totalWeeks == 0) {
            return 0;
        }

        return sum / totalWeeks;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Program program = new Program();
        boolean running = true;

        while (running) {

            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    CreatorStats creator = new CreatorStats();

                    System.out.println("Enter Creator Name:");
                    creator.setCreatorName(sc.nextLine());

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = Double.parseDouble(sc.nextLine());
                    }

                    creator.setWeeklyLikes(likes);
                    program.registerCreator(creator);

                    System.out.println("Creator registered successfully");
                    break;

                case 2:
                    System.out.println("Enter like threshold:");
                    double threshold = Double.parseDouble(sc.nextLine());

                    Map<String, Integer> result =
                            program.getTopPostCounts(
                                    CreatorStats.engagementBoard, threshold);

                    if (result.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : result.entrySet()) {
                            System.out.println(
                                    entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double avg = program.calculateAverageLikes();
                    System.out.println(
                            "Overall average weekly likes: " + avg);
                    break;

                case 4:
                    System.out.println(
                            "Logging off - Keep Creating with StreamBuzz!");
                    running = false;
                    break;
            }
        }
    }
}
