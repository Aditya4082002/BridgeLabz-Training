package com.employeewage.service;


public interface EmpWageService {

    void addCompany(String companyName,
                    int wagePerHour,
                    int maxWorkingDays,
                    int maxWorkingHours);

    void computeWages();

    int getTotalWage(String companyName);
}