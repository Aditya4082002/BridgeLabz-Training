package com.healthclinicapp.exception;

public class DuplicatePatientException extends Exception{
	public DuplicatePatientException(String message){
		super(message);
	}
}
