package com.employeewage.service;


import com.employeewage.model.CompanyEmpWage;
import com.employeewage.repository.CompanyRepository;

public class EmpWageBuilder implements EmpWageService {

    private CompanyRepository repository = new CompanyRepository();

    @Override
    public void addCompany(String name,
                           int wagePerHour,
                           int maxDays,
                           int maxHours) {
    	
    	// Regex validation for company name
        if (!name.matches("^[A-Za-z ]+$")) {
            throw new IllegalArgumentException("Invalid Company Name");
        }

        CompanyEmpWage company =
                new CompanyEmpWage(name, wagePerHour, maxDays, maxHours);

        repository.addCompany(company);
    }

    @Override
    public void computeWages() {

        for (CompanyEmpWage company : repository.getAllCompanies()) {

            int totalHours = 0;
            int totalDays = 0;
            int totalWage = 0;

            while (totalHours < company.getMaxWorkingHours() &&
                   totalDays < company.getMaxWorkingDays()) {

                totalDays++;

                int empCheck = (int)(Math.random() * 3);
                int empHours = 0;

                if (empCheck == 1)
                    empHours = 4;
                else if (empCheck == 2)
                    empHours = 8;

                totalHours += empHours;
                
                int dailyWage = empHours * company.getWagePerHour();

                // UC-13: Store daily wage
                company.addDailyWage(dailyWage);
                
                totalWage += empHours * company.getWagePerHour();
            }

            company.setTotalWage(totalWage);
        }
    }

    @Override
    public int getTotalWage(String companyName) {

        for (CompanyEmpWage company : repository.getAllCompanies()) {
            if (company.getCompanyName().equals(companyName)) {
                return company.getTotalWage();
            }
        }
        return 0;
    }
}