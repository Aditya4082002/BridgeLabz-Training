package scenario;

import java.util.*;

//Custom Exception 
class TableAlreadyReservedException extends Exception {
 public TableAlreadyReservedException(String message) {
     super(message);
 }
}

//Table Class
class Table {
 int tableNumber;
 int capacity;

 public Table(int tableNumber, int capacity) {
     this.tableNumber = tableNumber;
     this.capacity = capacity;
 }

 @Override
 public String toString() {
     return "Table " + tableNumber + " (Capacity: " + capacity + ")";
 }
}

//Reservation Class 
class Reservation {
 int tableNumber;
 String customerName;
 String timeSlot;

 public Reservation(int tableNumber, String customerName, String timeSlot) {
     this.tableNumber = tableNumber;
     this.customerName = customerName;
     this.timeSlot = timeSlot;
 }

 @Override
 public String toString() {
     return "Table " + tableNumber +
            " reserved by " + customerName +
            " at " + timeSlot;
 }
}

public class RestaurantReservationSystem {

 // Map: tableNumber -> Table
 private Map<Integer, Table> tables = new HashMap<>();

 // List of reservations
 private List<Reservation> reservations = new ArrayList<>();

 // Add table
 public void addTable(int tableNumber, int capacity) {
     tables.put(tableNumber, new Table(tableNumber, capacity));
 }

 // Reserve table
 public void reserveTable(int tableNumber, String customerName, String timeSlot)
         throws TableAlreadyReservedException {

     if (!tables.containsKey(tableNumber)) {
         System.out.println("Table not found!");
         return;
     }

     // Check for double booking
     for (Reservation r : reservations) {
         if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
             throw new TableAlreadyReservedException(
                     "Table " + tableNumber + " is already reserved at " + timeSlot
             );
         }
     }

     reservations.add(new Reservation(tableNumber, customerName, timeSlot));
     System.out.println("Reservation successful for " + customerName);
 }

 // Cancel reservation
 public void cancelReservation(int tableNumber, String timeSlot) {
     Iterator<Reservation> iterator = reservations.iterator();

     while (iterator.hasNext()) {
         Reservation r = iterator.next();
         if (r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
             iterator.remove();
             System.out.println("Reservation cancelled for Table " + tableNumber);
             return;
         }
     }
     System.out.println("Reservation not found!");
 }

 // Show available tables for a time slot
 public void showAvailableTables(String timeSlot) {
     System.out.println("\nAvailable Tables at " + timeSlot + ":");

     for (Table table : tables.values()) {
         boolean reserved = false;

         for (Reservation r : reservations) {
             if (r.tableNumber == table.tableNumber &&
                 r.timeSlot.equals(timeSlot)) {
                 reserved = true;
                 break;
             }
         }

         if (!reserved) {
             System.out.println(table);
         }
     }
 }

 public static void main(String[] args) {

     RestaurantReservationSystem system =
             new RestaurantReservationSystem();

     // Add tables
     system.addTable(1, 2);
     system.addTable(2, 4);
     system.addTable(3, 6);

     try {
         system.reserveTable(1, "Alice", "7PM-8PM");
         system.reserveTable(2, "Bob", "7PM-8PM");

         // Double booking attempt
         system.reserveTable(1, "Carol", "7PM-8PM");

     } catch (TableAlreadyReservedException e) {
         System.out.println(e.getMessage());
     }

     system.showAvailableTables("7PM-8PM");

     system.cancelReservation(1, "7PM-8PM");

     system.showAvailableTables("7PM-8PM");
 }
}
