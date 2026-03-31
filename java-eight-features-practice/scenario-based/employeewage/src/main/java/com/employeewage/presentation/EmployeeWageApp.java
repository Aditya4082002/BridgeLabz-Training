package com.employeewage.presentation;

import com.employeewage.service.EmpWageBuilder;

public class EmployeeWageApp {

    public static void main(String[] args) {

        EmpWageBuilder builder = new EmpWageBuilder();

        builder.addCompany("TCS", 20, 20, 100);
        builder.addCompany("Infosys", 25, 22, 110);

        builder.computeWages();

        System.out.println("TCS Wage: " +
                builder.getTotalWage("TCS"));

        System.out.println("Infosys Wage: " +
                builder.getTotalWage("Infosys"));
        
        

    }
}