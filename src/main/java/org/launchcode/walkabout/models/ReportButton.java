package org.launchcode.walkabout.models;

import jakarta.persistence.Entity;

public class ReportButton{
    private String name;
    private String report;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

}
