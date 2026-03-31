package collections.insurancepolicy;

import java.time.LocalDate;
import java.util.*;

public class PolicyManager {

    // 1) HashSet: fastest lookup
    private Set<Policy> hashSetPolicies = new HashSet<>();

    // 2) LinkedHashSet: preserves insertion order
    private Set<Policy> linkedHashSetPolicies = new LinkedHashSet<>();

    // 3) TreeSet: sorted by expiry date (then policyNumber to avoid collision)
    private Set<Policy> treeSetPolicies = new TreeSet<>(
            (p1, p2) -> {
                int cmp = p1.getExpiryDate().compareTo(p2.getExpiryDate());
                if (cmp == 0) {
                    return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
                }
                return cmp;
            }
    );

    //Add policy to all sets
    public void addPolicy(Policy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    //Remove policy from all sets using policyNumber
    public boolean removePolicyByNumber(String policyNumber) {
        Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0);

        boolean removed = false;
        removed |= hashSetPolicies.remove(dummy);
        removed |= linkedHashSetPolicies.remove(dummy);
        removed |= treeSetPolicies.remove(dummy);

        return removed;
    }

    //Search policy quickly (best with HashSet)
    public boolean containsPolicy(String policyNumber) {
        Policy dummy = new Policy(policyNumber, "", LocalDate.now(), "", 0);
        return hashSetPolicies.contains(dummy);
    }

    //Get all unique policies (your choice: HashSet / LinkedHashSet / TreeSet)
    public Set<Policy> getAllUniquePoliciesHashSet() {
        return new HashSet<>(hashSetPolicies);
    }

    public Set<Policy> getAllUniquePoliciesLinkedHashSet() {
        return new LinkedHashSet<>(linkedHashSetPolicies);
    }

    public Set<Policy> getAllUniquePoliciesTreeSet() {
        Set<Policy> sortedSet = new TreeSet<>(
                (p1, p2) -> {
                    int cmp = p1.getExpiryDate().compareTo(p2.getExpiryDate());
                    if (cmp == 0) {
                        return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
                    }
                    return cmp;
                }
        );

        sortedSet.addAll(treeSetPolicies);
        return sortedSet;
    }


    //Policies expiring within next N days
    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(days);

        List<Policy> result = new ArrayList<>();
        for (Policy p : treeSetPolicies) { // already sorted by expiry date ✅
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                result.add(p);
            }
        }
        return result;
    }

    //Policies with specific coverage type
    public List<Policy> getPoliciesByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSetPolicies) {
            if (p.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(p);
            }
        }
        return result;
    }

    //Duplicate policies based on policy number (input list check)
    public static List<String> findDuplicatePolicyNumbers(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>();

        for (Policy p : policies) {
            if (!seen.add(p.getPolicyNumber())) {
                duplicates.add(p.getPolicyNumber());
            }
        }
        return new ArrayList<>(duplicates);
    }

    //Performance comparison (add / search / remove)
    public static void comparePerformance(List<Policy> policies) {
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(
                (p1, p2) -> {
                    int cmp = p1.getExpiryDate().compareTo(p2.getExpiryDate());
                    if (cmp == 0) {
                        return p1.getPolicyNumber().compareTo(p2.getPolicyNumber());
                    }
                    return cmp;
                }
        );

        // ADD
        long t1 = System.nanoTime();
        for (Policy p : policies) hashSet.add(p);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        for (Policy p : policies) linkedHashSet.add(p);
        long t4 = System.nanoTime();

        long t5 = System.nanoTime();
        for (Policy p : policies) treeSet.add(p);
        long t6 = System.nanoTime();

        // SEARCH
        Policy searchTarget = policies.get(policies.size() / 2);

        long s1 = System.nanoTime();
        hashSet.contains(searchTarget);
        long s2 = System.nanoTime();

        long s3 = System.nanoTime();
        linkedHashSet.contains(searchTarget);
        long s4 = System.nanoTime();

        long s5 = System.nanoTime();
        treeSet.contains(searchTarget);
        long s6 = System.nanoTime();

        // REMOVE
        long r1 = System.nanoTime();
        hashSet.remove(searchTarget);
        long r2 = System.nanoTime();

        long r3 = System.nanoTime();
        linkedHashSet.remove(searchTarget);
        long r4 = System.nanoTime();

        long r5 = System.nanoTime();
        treeSet.remove(searchTarget);
        long r6 = System.nanoTime();

        System.out.println("---- Performance Results (nanoseconds) ----");
        System.out.println("ADD:        HashSet=" + (t2 - t1) + "  LinkedHashSet=" + (t4 - t3) + "  TreeSet=" + (t6 - t5));
        System.out.println("SEARCH:     HashSet=" + (s2 - s1) + "  LinkedHashSet=" + (s4 - s3) + "  TreeSet=" + (s6 - s5));
        System.out.println("REMOVE:     HashSet=" + (r2 - r1) + "  LinkedHashSet=" + (r4 - r3) + "  TreeSet=" + (r6 - r5));
    }
}
