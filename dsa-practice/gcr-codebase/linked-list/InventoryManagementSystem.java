package linkedList;

// Node class
class ItemNode {
    int itemId;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }
}

// Singly Linked List
class Inventory {
    ItemNode head;

    // insert at beginning
    public void insertAtBeginning(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = head;
        head = newNode;
    }

    // insert at end
    public void insertAtLast(int id, String name, int qty, double price) {
        ItemNode newNode = new ItemNode(id, name, qty, price);

        if (head == null) {
            head = newNode;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // insert at specific position (1-based)
    public void insertAtPosition(int id, String name, int qty, double price, int position) {
        if (position == 1) {
            insertAtBeginning(id, name, qty, price);
            return;
        }

        ItemNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        ItemNode newNode = new ItemNode(id, name, qty, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // delete item by ID
    public void deleteItem(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        ItemNode temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // update quantity
    public void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null && temp.itemId != id) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.quantity = newQty;
            System.out.println("Quantity updated.");
        }
    }

    // search by ID
    public void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // search by name
    public void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // total inventory value
    public void totalInventoryValue() {
        double total = 0;
        ItemNode temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }

        System.out.println("Total Inventory Value = " + total);
    }

    // display items
    public void displayItems() {
        ItemNode temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // ================= MERGE SORT =================

    public void sortByName(boolean ascending) {
        head = mergeSort(head, true, ascending);
    }

    public void sortByPrice(boolean ascending) {
        head = mergeSort(head, false, ascending);
    }

    private ItemNode mergeSort(ItemNode head, boolean byName, boolean asc) {
        if (head == null || head.next == null)
            return head;

        ItemNode middle = getMiddle(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, byName, asc);
        ItemNode right = mergeSort(nextOfMiddle, byName, asc);

        return sortedMerge(left, right, byName, asc);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, boolean byName, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (byName) {
            condition = asc ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = asc ? a.price <= b.price : a.price > b.price;
        }

        ItemNode result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, byName, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, byName, asc);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode head) {
        ItemNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // helper
    private void displayItem(ItemNode item) {
        System.out.println("ID : " + item.itemId);
        System.out.println("Name : " + item.itemName);
        System.out.println("Quantity : " + item.quantity);
        System.out.println("Price : " + item.price);
        System.out.println("--------------------");
    }
}

// Main class
public class InventoryManagementSystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.insertAtLast(1, "Laptop", 5, 60000);
        inventory.insertAtLast(2, "Mouse", 20, 500);
        inventory.insertAtBeginning(3, "Keyboard", 10, 1500);
        inventory.insertAtPosition(4, "Monitor", 7, 12000, 2);

        inventory.updateQuantity(2, 25);

        inventory.searchById(1);
        inventory.searchByName("Mouse");

        inventory.totalInventoryValue();

        System.out.println("\nSorted by Name (ASC):");
        inventory.sortByName(true);
        inventory.displayItems();

        System.out.println("\nSorted by Price (DESC):");
        inventory.sortByPrice(false);
        inventory.displayItems();
    }
}
