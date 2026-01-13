package com.oops.courseRegistration;

abstract class RegistrationService {
    abstract void enroll(Student student, String course);
    abstract void drop(Student student, String course);
}
