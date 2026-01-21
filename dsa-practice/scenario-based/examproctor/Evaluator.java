package examproctor;

import java.util.HashMap;

public class Evaluator {

    // Function to calculate score
    public int calculateScore(HashMap<Integer, String> studentAnswers,
                              HashMap<Integer, String> correctAnswers) {

        int score = 0;

        for (Integer questionId : correctAnswers.keySet()) {

            if (studentAnswers.containsKey(questionId)) {

                String studentAnswer = studentAnswers.get(questionId);
                String correctAnswer = correctAnswers.get(questionId);

                if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                    score++;
                }
            }
        }

        return score;
    }
}
