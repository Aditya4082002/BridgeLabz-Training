package scenrioBase;

class InvalidInvoiceFormatException extends Exception {

    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGeneratorWithException {

    // method to extract task names and amounts
    public static String[][] parseInvoice(String input) throws InvalidInvoiceFormatException {

        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInvoiceFormatException("Invoice input is empty");
        }

        String[] values = input.trim().split(",");
        String[][] tasks = new String[2][values.length];

        int index = 0;

        for (String task : values) {

            if (!task.contains("-")) {
                throw new InvalidInvoiceFormatException("Missing '-' in task entry: " + task);
            }

            String[] parts = task.split("-");

            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException( "Invalid task format: ");
            }

            String taskName = parts[0].trim();
            String[] amountPart = parts[1].trim().split(" ");

            if (amountPart.length < 1 || amountPart[0].isEmpty()) {
                throw new InvalidInvoiceFormatException("Missing amount for task: " + taskName);
            }

            try {
                Integer.parseInt(amountPart[0]);
            } catch (NumberFormatException e) {
                throw new InvalidInvoiceFormatException("Invalid amount for task: " + taskName);
            }

            tasks[0][index] = taskName;
            tasks[1][index] = amountPart[0];
            index++;
        }

        return tasks;
    }

    // method to get total amount
    public static int getTotalAmount(String[] amounts) {
        int total = 0;

        for (String amount : amounts) {
            total += Integer.parseInt(amount);
        }

        return total;
    }

    public static void main(String[] args) {

        String input = "Logo Design  3000 INR,Web Page - 4500 INR";

        try {
            String[][] tasks = parseInvoice(input);
            System.out.println("Total Amount: " + getTotalAmount(tasks[1]));
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Invoice Error: " + e.getMessage());
        }
    }
}
