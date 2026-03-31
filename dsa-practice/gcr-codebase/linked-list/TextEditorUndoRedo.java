package linkedList;

// Node class
class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
    }
}

// Doubly Linked List for Undo/Redo
class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // add new text state
    public void addState(String content) {

        TextState newState = new TextState(content);

        // if some redo states exist, remove them
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = calculateSize();
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // undo operation
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    // redo operation
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    // display current text
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    // helper to recalculate size
    private int calculateSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

// Main class
public class TextEditorUndoRedo {

    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World!!!");
        editor.displayCurrentState();

        editor.redo(); // should not work
    }
}
