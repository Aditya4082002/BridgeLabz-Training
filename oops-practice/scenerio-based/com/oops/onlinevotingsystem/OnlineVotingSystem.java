package com.oops.onlinevotingsystem;

public class OnlineVotingSystem {

    public static void main(String[] args) {

        ElectionService election = new ElectionServiceImpl();

        // Candidates
        Candidate c1 = new Candidate(1, "Candidate A");
        Candidate c2 = new Candidate(2, "Candidate B");

        election.addCandidate(c1);
        election.addCandidate(c2);

        // Voters
        Voter v1 = new Voter(101, "Aditya");
        Voter v2 = new Voter(102, "Rahul");

        election.registerVoter(v1);
        election.registerVoter(v2);

        try {
            election.castVote(v1, c1);
            election.castVote(v2, c2);
            election.castVote(v1, c2); // duplicate vote
        } catch (DuplicateVoteException e) {
            System.out.println("Voting Error: " + e.getMessage());
        }

        election.declareResults();
    }
}