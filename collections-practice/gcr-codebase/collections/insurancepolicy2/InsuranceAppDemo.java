package collections.insurancepolicy2;

import java.time.LocalDate;
import java.util.*;

public class InsuranceAppDemo {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        manager.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(50), "Auto", 3000));
        manager.addPolicy(new Policy("P103", "Alice", LocalDate.now().plusDays(20), "Home", 7000));
        manager.addPolicy(new Policy("P104", "Carol", LocalDate.now().minusDays(2), "Auto", 2500)); // expired

        System.out.println("Retrieve Policy P103:");
        System.out.println(manager.getPolicyByNumber("P103"));

        System.out.println("\nPolicies expiring within 30 days:");
        System.out.println(manager.getPoliciesExpiringSoon(30));

        System.out.println("\nPolicies for policyholder Alice:");
        System.out.println(manager.getPoliciesByPolicyholder("Alice"));

        System.out.println("\nAll policies in insertion order:");
        manager.displayAllPoliciesInsertionOrder();

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nPolicies sorted by expiry date:");
        manager.displayPoliciesSortedByExpiry();
    }
}
