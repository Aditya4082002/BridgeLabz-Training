package parceltracker;

public class ParcelRoute {

    private StageNode head;

    // Add default stages
    public void initializeRoute() {
        addStage("Packed");
        addStage("Shipped");
        addStage("In Transit");
        addStage("Delivered");
    }

    // Add stage at end
    public void addStage(String stage) {

        StageNode newNode = new StageNode(stage);

        if (head == null) {
            head = newNode;
            return;
        }

        StageNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Add custom checkpoint after a given stage
    public void addAfter(String afterStage, String newStage) {

        StageNode temp = head;

        while (temp != null && !temp.stage.equalsIgnoreCase(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found: " + afterStage);
            return;
        }

        StageNode newNode = new StageNode(newStage);
        newNode.next = temp.next;
        temp.next = newNode;

        System.out.println("Added checkpoint: " + newStage + " after " + afterStage);
    }

    // Forward tracking
    public void trackParcel() {

        if (head == null) {
            System.out.println("Parcel route is missing (null pointer)");
            return;
        }

        System.out.println("\nParcel Tracking:");

        StageNode temp = head;

        while (temp != null) {
            System.out.println("→ " + temp.stage);
            temp = temp.next;
        }
    }

    // Simulate lost parcel (break chain)
    public void markLostAfter(String stage) {

        StageNode temp = head;

        while (temp != null && !temp.stage.equalsIgnoreCase(stage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found");
        } else {
            temp.next = null;
            System.out.println("Parcel lost after: " + stage);
        }
    }
}
