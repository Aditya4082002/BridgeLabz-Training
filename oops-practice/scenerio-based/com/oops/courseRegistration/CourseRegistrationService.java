package com.oops.courseRegistration;

class CourseRegistrationService extends RegistrationService {

    @Override
    void enroll(Student student, String course) {
        try {
            student.addCourse(course);
        } catch (CourseLimitExceededException e) {
            System.out.println("Enrollment failed: " + e.getMessage());
        }
    }

    @Override
    void drop(Student student, String course) {
        student.dropCourse(course);
    }
}