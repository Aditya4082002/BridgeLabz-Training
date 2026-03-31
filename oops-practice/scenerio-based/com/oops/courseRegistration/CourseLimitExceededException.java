package com.oops.courseRegistration;

class CourseLimitExceededException extends Exception{
	public CourseLimitExceededException(String message){
		super(message);
	}
}
