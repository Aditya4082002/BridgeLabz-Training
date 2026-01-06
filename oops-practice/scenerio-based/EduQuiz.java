package scenrioBase;

public class EduQuiz {

    // Method to calculate score and print feedback
    static int calculateScore(String[] correct, String[] student) {
        int score = 0;

        System.out.println("Quiz Feedback:");

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        return score;
    }

    public static void main(String[] args) {

        // Correct answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "C", "B", "D", "A", "B"};

        // Student answers
        String[] studentAnswers = {"a", "b", "c", "a", "A", "c", "d", "d", "a", "b" };

        // Calculate score
        int score = calculateScore(correctAnswers, studentAnswers);

        // Calculate percentage
        double percentage = (score / 10.0) * 100;

        // Display results
        System.out.println("Result Summary:");
        System.out.println("Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        // Pass / Fail decision
        if (percentage >= 40) {
            System.out.println("Status: PASS ");
        } else {
            System.out.println("Status: FAIL ");
        }
    }
}
