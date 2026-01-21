package browserbuddy;

public class BrowserBuddy {

    public static void main(String[] args) {

        BrowserManager browser = new BrowserManager();
        Tab tab = browser.getCurrentTab();

        // Browsing
        tab.visit("google.com");
        tab.visit("youtube.com");
        tab.visit("github.com");

        tab.back();
        tab.back();
        tab.forward();

        System.out.println("Current Page: " + tab.getCurrentPage());

        // Close tab
        browser.closeTab();

        // Restore tab
        browser.restoreTab();

        // Continue browsing
        tab = browser.getCurrentTab();
        tab.forward();
    }
}
