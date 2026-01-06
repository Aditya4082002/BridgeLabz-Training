package scenrioBase;

import java.util.ArrayList;
import java.util.List;

public class OnlineQuizResultProcessor {

    // Custom Exception
    static class InvalidQuizSubmissionException extends Exception {
        InvalidQuizSubmissionException(String message) {
            super(message);
        }
    }

    // Quiz Processor logic
    static class QuizProcessor {

        private List<Integer> userScores = new ArrayList<>();

        // Compare answers and calculate score
        int calculateScore(String[] correctAnswers, String[] userAnswers)
                throws InvalidQuizSubmissionException {

            if (correctAnswers == null || userAnswers == null) {
                throw new InvalidQuizSubmissionException("Answers cannot be null");
            }

            if (correctAnswers.length != userAnswers.length) {
                throw new InvalidQuizSubmissionException(
                        "Answer length mismatch"
                );
            }

            int score = 0;

            for (int i = 0; i < correctAnswers.length; i++) {
                if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                    score++;
                }
            }

            userScores.add(score);
            return score;
        }

        // Return grade based on score
        String getGrade(int score, int totalQuestions) {

            double percentage = (score * 100.0) / totalQuestions;

            if (percentage >= 80) {
                return "A";
            } else if (percentage >= 60) {
                return "B";
            } else if (percentage >= 40) {
                return "C";
            } else {
                return "Fail";
            }
        }

        // Display all user scores
        void displayAllScores() {

            System.out.println("All User Scores:");
            for (int score : userScores) {
                System.out.println(score);
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        QuizProcessor processor = new QuizProcessor();

        String[] correctAnswers = {"A", "B", "C", "D", "A"};

        String[] user1Answers = {"A", "B", "C", "A", "A"};

        String[] user2Answers = {"A", "C", "C", "D", "A"};

        try {
            int score1 = processor.calculateScore(correctAnswers, user1Answers);
            System.out.println("User 1 Score: " + score1 +", Grade: " +processor.getGrade(score1, correctAnswers.length) );

            int score2 = processor.calculateScore(correctAnswers, user2Answers);
            System.out.println("User 2 Score: " + score2 +", Grade: " +processor.getGrade(score2, correctAnswers.length));

        } catch (InvalidQuizSubmissionException e) {
            System.out.println(e.getMessage());
        }

        processor.displayAllScores();
    }
}