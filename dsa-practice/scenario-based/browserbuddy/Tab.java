package browserbuddy;

public class Tab {

    private Page current;

    // Visit new page
    public void visit(String url) {

        Page newPage = new Page(url);

        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }

        current = newPage;
        System.out.println("Visited: " + url);
    }

    // Back 
    public void back() {

        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page");
        }
    }

    // Forward 
    public void forward() {

        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No next page");
        }
    }

    public String getCurrentPage() {
        if (current == null) {
            return "No page open";
        }
        return current.url;
    }
}
