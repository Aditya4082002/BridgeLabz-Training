package browserbuddy;

import java.util.Stack;

public class BrowserManager {

    private Stack<Tab> closedTabs = new Stack<>();
    private Tab currentTab = new Tab();

    public Tab getCurrentTab() {
        return currentTab;
    }

    // Close current tab
    public void closeTab() {
        closedTabs.push(currentTab);
        currentTab = new Tab();
        System.out.println("Tab closed");
    }

    // Restore last closed tab
    public void restoreTab() {

        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore");
        } else {
            currentTab = closedTabs.pop();
            System.out.println("Tab restored. Current page: " + currentTab.getCurrentPage());
        }
    }
}
