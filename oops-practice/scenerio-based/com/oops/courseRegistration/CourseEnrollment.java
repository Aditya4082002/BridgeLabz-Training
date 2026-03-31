package com.oops.courseRegistration;

public class CourseEnrollment {
	private String courseName;
	private String grade;
	
	
	CourseEnrollment(String courseName) {
        this.courseName = courseName;
        this.grade = "Not Assigned";
    }
	public String getCourseName() {
        return courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
	
}
