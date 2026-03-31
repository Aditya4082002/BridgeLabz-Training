package com.employeewage.repository;


import com.employeewage.model.CompanyEmpWage;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private List<CompanyEmpWage> companyList = new ArrayList<>();

    public void addCompany(CompanyEmpWage company) {
        companyList.add(company);
    }

    public List<CompanyEmpWage> getAllCompanies() {
        return companyList;
    }
}