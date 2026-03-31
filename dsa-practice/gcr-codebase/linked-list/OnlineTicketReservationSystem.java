package linkedList;

// Node class
class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName,
                      String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

// Circular Linked List
class TicketReservationSystem {
    TicketNode head = null;
    TicketNode tail = null;

    // add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // remove ticket by ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode curr = head;
        TicketNode prev = tail;

        do {
            if (curr.ticketId == id) {

                // only one node
                if (curr == head && curr == tail) {
                    head = tail = null;
                    System.out.println("Ticket cancelled.");
                    return;
                }

                // deleting head
                if (curr == head) {
                    head = head.next;
                    tail.next = head;
                }
                // deleting tail
                else if (curr == tail) {
                    tail = prev;
                    tail.next = head;
                }
                // deleting middle
                else {
                    prev.next = curr.next;
                }

                System.out.println("Ticket cancelled.");
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Ticket not found.");
    }

    // display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        do {
            displayTicket(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // search by customer name
    public void searchByCustomer(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for customer: " + customerName);
        }
    }

    // search by movie name
    public void searchByMovie(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                displayTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No ticket found for movie: " + movieName);
        }
    }

    // count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        TicketNode temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets: " + count);
    }

    // helper method
    private void displayTicket(TicketNode ticket) {
        System.out.println("Ticket ID : " + ticket.ticketId);
        System.out.println("Customer : " + ticket.customerName);
        System.out.println("Movie : " + ticket.movieName);
        System.out.println("Seat : " + ticket.seatNumber);
        System.out.println("Time : " + ticket.bookingTime);
        System.out.println("----------------------");
    }
}

// Main class
public class OnlineTicketReservationSystem {

    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Aditya", "Inception", "A10", "10:00 AM");
        system.addTicket(102, "Rahul", "Avatar", "B12", "10:15 AM");
        system.addTicket(103, "Neha", "Inception", "A11", "10:20 AM");

        System.out.println("All Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer:");
        system.searchByCustomer("Aditya");

        System.out.println("\nSearch by Movie:");
        system.searchByMovie("Inception");

        system.countTickets();

        system.removeTicket(102);

        System.out.println("\nAfter Cancellation:");
        system.displayTickets();

        system.countTickets();
    }
}
