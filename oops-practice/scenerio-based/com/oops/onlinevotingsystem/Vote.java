package com.oops.onlinevotingsystem;

class Vote {
    private Voter voter;
    private Candidate candidate;

    Vote(Voter voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    public Candidate getCandidate() {
        return candidate;
    }
}
