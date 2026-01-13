package com.oops.onlinevotingsystem;

class DuplicateVoteException extends Exception {
    public DuplicateVoteException(String message) {
        super(message);
    }
}