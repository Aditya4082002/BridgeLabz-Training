package collections;

import java.util.*;

class VotingSystem {

    // HashMap: fast counting (Candidate -> Votes)
    private final Map<String, Integer> voteCount = new HashMap<>();

    // LinkedHashMap: maintains insertion order (vote log)
    // Candidate -> how many times candidate got voted (but keeps order of first vote)
    private final Map<String, Integer> voteOrder = new LinkedHashMap<>();

    // Cast a vote
    public void vote(String candidate) {
        if (candidate == null || candidate.trim().isEmpty()) {
            throw new IllegalArgumentException("Candidate name cannot be empty");
        }

        candidate = candidate.trim();

        // update HashMap count
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        // update LinkedHashMap to preserve order of first appearance
        voteOrder.put(candidate, voteOrder.getOrDefault(candidate, 0) + 1);
    }

    // Display votes in sorted order using TreeMap
    public void displaySortedResults() {
        Map<String, Integer> sorted = new TreeMap<>(voteCount);

        System.out.println("---- Voting Results (Sorted) ----");
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Display votes in insertion order (first time candidate appeared)
    public void displayInsertionOrderResults() {
        System.out.println("---- Voting Results (Insertion Order) ----");
        for (Map.Entry<String, Integer> entry : voteOrder.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // Get winner (max votes)
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }
}

public class VotingSystemDemo {
    public static void main(String[] args) {

        VotingSystem vs = new VotingSystem();

        // votes
        vs.vote("Alice");
        vs.vote("Bob");
        vs.vote("Alice");
        vs.vote("Carol");
        vs.vote("Bob");
        vs.vote("Alice");

        vs.displayInsertionOrderResults();
        System.out.println();

        vs.displaySortedResults();
        System.out.println();

        System.out.println("Winner: " + vs.getWinner());
    }
}
