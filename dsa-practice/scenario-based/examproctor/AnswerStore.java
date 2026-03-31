package examproctor;

import java.util.HashMap;

public class AnswerStore {

    private HashMap<Integer, String> answers = new HashMap<>();

    public void submitAnswer(int questionId, String answer) {
        answers.put(questionId, answer);
        System.out.println("Answer saved for Q" + questionId);
    }

    public String getAnswer(int questionId) {
        return answers.get(questionId);
    }

    public HashMap<Integer, String> getAllAnswers() {
        return answers;
    }
}
