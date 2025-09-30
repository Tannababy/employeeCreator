package com.projects.employeeCreator.model;

import java.util.Date;

public class ContractInfo {

    private Date startDate;
    private String contractType;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}
