package com.employeewage.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalWage;

    // UC-13: Store daily wages
    private List<Integer> dailyWages;

    public CompanyEmpWage(String companyName,
                          int wagePerHour,
                          int maxWorkingDays,
                          int maxWorkingHours) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.dailyWages = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getWagePerHour() {
        return wagePerHour;
    }

    public int getMaxWorkingDays() {
        return maxWorkingDays;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public int getTotalWage() {
        return totalWage;
    }

    //  UC-13: Add daily wage
    public void addDailyWage(int dailyWage) {
        dailyWages.add(dailyWage);
    }

    public List<Integer> getDailyWages() {
        return dailyWages;
    }
}
