package collections.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class InsuranceAppDemo {
    public static void main(String[] args) {

        PolicyManager manager = new PolicyManager();

        // Input list with duplicates (same policy number)
        List<Policy> inputPolicies = Arrays.asList(
                new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000),
                new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000),
                new Policy("P103", "Carol", LocalDate.now().plusDays(20), "Home", 7000),
                new Policy("P101", "Alice Duplicate", LocalDate.now().plusDays(15), "Health", 6000) // duplicate number
        );

        // Add policies to manager (duplicates auto ignored in sets)
        for (Policy p : inputPolicies) {
            manager.addPolicy(p);
        }

        System.out.println("All Unique Policies (HashSet):");
        System.out.println(manager.getAllUniquePoliciesHashSet());

        System.out.println("\nAll Unique Policies (LinkedHashSet - insertion order):");
        System.out.println(manager.getAllUniquePoliciesLinkedHashSet());

        System.out.println("\nAll Unique Policies (TreeSet - sorted by expiry):");
        System.out.println(manager.getAllUniquePoliciesTreeSet());

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        System.out.println(manager.getPoliciesExpiringSoon(30));

        System.out.println("\nPolicies with Coverage Type = Health:");
        System.out.println(manager.getPoliciesByCoverageType("Health"));

        System.out.println("\nDuplicate Policy Numbers in input list:");
        System.out.println(PolicyManager.findDuplicatePolicyNumbers(inputPolicies));

        System.out.println("\nPerformance Comparison:");
        PolicyManager.comparePerformance(inputPolicies);
    }
}
