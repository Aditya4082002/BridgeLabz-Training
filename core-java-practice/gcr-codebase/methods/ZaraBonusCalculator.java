public class ZaraBonusCalculator {

    public static void main(String[] args) {

        // Generate employee data: salary & years of service
        double[][] employeeData = generateEmployeeData();

        // Calculate new salary and bonus
        double[][] updatedSalaryData = calculateBonusAndNewSalary(employeeData);

        // Display final report
        displaySalaryReport(employeeData, updatedSalaryData);
    }

    // Method to generate salary and years of service
    public static double[][] generateEmployeeData() {

        double[][] data = new double[10][2]; // [salary][years of service]

        for (int i = 0; i < 10; i++) {

            // Generate random 5-digit salary (10000–99999)
            data[i][0] = 10000 + (Math.random() * 90000);

            // Generate random years of service (1–10)
            data[i][1] = 1 + (Math.random() * 10);
        }
        return data;
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {

        double[][] updatedData = new double[10][2]; // [bonus][new salary]

        for (int i = 0; i < 10; i++) {

            double salary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double bonusRate;

            // Bonus calculation logic
            if (yearsOfService > 5) {
                bonusRate = 0.05;
            } else {
                bonusRate = 0.02;
            }

            double bonusAmount = salary * bonusRate;
            double newSalary = salary + bonusAmount;

            updatedData[i][0] = bonusAmount;
            updatedData[i][1] = newSalary;
        }
        return updatedData;
    }

    // Method to calculate totals and display results in tabular format
    public static void displaySalaryReport( double[][] employeeData, double[][] updatedSalaryData) {

        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-5s %-12s %-10s %-12s %-12s%n","ID", "Old Salary", "Years", "Bonus", "New Salary");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {

            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonus = updatedSalaryData[i][0];
            double newSalary = updatedSalaryData[i][1];

            totalOldSalary += oldSalary;
            totalBonus += bonus;
            totalNewSalary += newSalary;

            System.out.printf("%-5d %-12.2f %-10.1f %-12.2f %-12.2f%n",(i + 1), oldSalary, years, bonus, newSalary);
        }

        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-18s %.2f%n", "Total Old Salary:", totalOldSalary);
        System.out.printf("%-18s %.2f%n", "Total Bonus Paid:", totalBonus);
        System.out.printf("%-18s %.2f%n", "Total New Salary:", totalNewSalary);
        System.out.println("---------------------------------------------------------------");
    }
}