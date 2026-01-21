package examproctor;

import java.util.HashMap;

public class ExamProctorApp {

    public static void main(String[] args) {

        QuestionNavigation navigation = new QuestionNavigation();
        AnswerStore store = new AnswerStore();
        Evaluator evaluator = new Evaluator();

        // Simulating navigation
        navigation.visitQuestion(1);
        navigation.visitQuestion(2);
        navigation.visitQuestion(3);

        // Submitting answers
        store.submitAnswer(1, "A");
        store.submitAnswer(2, "B");
        store.submitAnswer(3, "C");

        // Correct answers
        HashMap<Integer, String> correctAnswers = new HashMap<>();
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "C");
        correctAnswers.put(3, "C");

        // Evaluation
        int score = evaluator.calculateScore(store.getAllAnswers(),correctAnswers);

        System.out.println("\nFinal Score: " + score + "/3");
    }
}
