package org.launchcode.walkabout.models;

import jakarta.persistence.Entity;

@Entity
public class ReportButton extends AbstractEntity{
    private String name;
    private String report;
    private String otherUsername;

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

    public String getOtherUsername() {
        return otherUsername;
    }

    public void setOtherUsername(String otherUsername) {
        this.otherUsername = otherUsername;
    }
}
