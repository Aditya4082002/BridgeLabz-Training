package examproctor;

import java.util.Stack;

public class QuestionNavigation {

    private Stack<Integer> questionStack = new Stack<>();

    public void visitQuestion(int questionId) {
        questionStack.push(questionId);
        System.out.println("Visited Question: " + questionId);
    }

    public int goBack() {
        if (questionStack.isEmpty()) {
            System.out.println("No previous questions");
            return -1;
        }
        return questionStack.pop();
    }

    public boolean isEmpty() {
        return questionStack.isEmpty();
    }
}
