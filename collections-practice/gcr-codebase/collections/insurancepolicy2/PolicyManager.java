package collections.insurancepolicy2;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    // 1) HashMap: policyNumber -> Policy (fast lookup)
    private final Map<String, Policy> hashMap = new HashMap<>();

    // 2) LinkedHashMap: insertion order
    private final Map<String, Policy> linkedHashMap = new LinkedHashMap<>();

    // 3) TreeMap: sorted by expiry date
    private final TreeMap<LocalDate, List<Policy>> expiryTreeMap = new TreeMap<>();

    // Add Policy
    public void addPolicy(Policy policy) {
        String policyNo = policy.getPolicyNumber();

        // store in HashMap & LinkedHashMap
        hashMap.put(policyNo, policy);
        linkedHashMap.put(policyNo, policy);

        // store in TreeMap by expiry date
        expiryTreeMap.putIfAbsent(policy.getExpiryDate(), new ArrayList<>());
        expiryTreeMap.get(policy.getExpiryDate()).add(policy);
    }

    // Retrieve policy by number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // List all policies expiring within next 30 days
    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(days);

        List<Policy> result = new ArrayList<>();

        // TreeMap helps because it's sorted by expiry date
        for (Map.Entry<LocalDate, List<Policy>> entry : expiryTreeMap.entrySet()) {
            LocalDate expiry = entry.getKey();

            if (expiry.isBefore(today)) continue;
            if (expiry.isAfter(limit)) break;

            result.addAll(entry.getValue());
        }

        return result;
    }

    // List all policies for a specific policyholder
    public List<Policy> getPoliciesByPolicyholder(String policyholderName) {
        List<Policy> result = new ArrayList<>();

        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }

        return result;
    }

    // Remove expired policies (expiryDate < today)
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();

        // collect expired policy numbers
        List<String> expiredPolicyNumbers = new ArrayList<>();

        for (Policy policy : hashMap.values()) {
            if (policy.getExpiryDate().isBefore(today)) {
                expiredPolicyNumbers.add(policy.getPolicyNumber());
            }
        }

        // remove from HashMap + LinkedHashMap
        for (String policyNo : expiredPolicyNumbers) {
            Policy removed = hashMap.remove(policyNo);
            linkedHashMap.remove(policyNo);

            // remove from TreeMap list
            if (removed != null) {
                LocalDate expiry = removed.getExpiryDate();
                List<Policy> list = expiryTreeMap.get(expiry);
                if (list != null) {
                    list.removeIf(p -> p.getPolicyNumber().equals(policyNo));
                    if (list.isEmpty()) {
                        expiryTreeMap.remove(expiry);
                    }
                }
            }
        }
    }

    // Display all policies (HashMap)
    public void displayAllPoliciesHashMap() {
        System.out.println("---- Policies (HashMap) ----");
        for (Policy p : hashMap.values()) {
            System.out.println(p);
        }
    }

    // Display all policies (LinkedHashMap insertion order)
    public void displayAllPoliciesInsertionOrder() {
        System.out.println("---- Policies (LinkedHashMap - Insertion Order) ----");
        for (Policy p : linkedHashMap.values()) {
            System.out.println(p);
        }
    }

    // Display policies sorted by expiry date (TreeMap)
    public void displayPoliciesSortedByExpiry() {
        System.out.println("---- Policies (TreeMap - Sorted by Expiry Date) ----");

        for (Map.Entry<LocalDate, List<Policy>> entry : expiryTreeMap.entrySet()) {
            for (Policy p : entry.getValue()) {
                System.out.println(p);
            }
        }
    }
}
