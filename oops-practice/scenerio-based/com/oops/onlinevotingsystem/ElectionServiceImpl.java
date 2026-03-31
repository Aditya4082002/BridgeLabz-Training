package com.oops.onlinevotingsystem;
import java.util.*;

class ElectionServiceImpl implements ElectionService {

    private List<Voter> voters = new ArrayList<>();
    private List<Candidate> candidates = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    @Override
    public void registerVoter(Voter voter) {
        voters.add(voter);
        System.out.println("Voter registered: " + voter.getName());
    }

    @Override
    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
        System.out.println("Candidate added: " + candidate.getName());
    }

    @Override
    public void castVote(Voter voter, Candidate candidate)
            throws DuplicateVoteException {

        if (voter.hasVoted()) {
            throw new DuplicateVoteException(
                    "Duplicate vote not allowed for voter: " + voter.getName());
        }

        Vote vote = new Vote(voter, candidate);
        votes.add(vote);
        candidate.addVote();
        voter.markVoted();

        System.out.println(voter.getName() +
                " voted for " + candidate.getName());
    }

    @Override
    public void declareResults() {
        System.out.println("\nElection Results:");
        for (Candidate c : candidates) {
            System.out.println(
                c.getName() + " : " + c.getVoteCount() + " votes"
            );
        }
    }
}