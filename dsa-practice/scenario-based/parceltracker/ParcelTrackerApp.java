package parceltracker;

public class ParcelTrackerApp {

    public static void main(String[] args) {

        ParcelRoute route = new ParcelRoute();

        // Initialize default delivery chain
        route.initializeRoute();
        route.trackParcel();

        // Add custom checkpoint
        route.addAfter("Shipped", "Warehouse Scan");
        route.trackParcel();

        // Simulate lost parcel
        route.markLostAfter("In Transit");
        route.trackParcel();
    }
}
