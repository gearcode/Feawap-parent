package com.gearcode.feawap.domain;

public class SoftwareWithBLOBs extends Software {
    private String description;

    private String application;

    private String caseAnalysis;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getCaseAnalysis() {
        return caseAnalysis;
    }

    public void setCaseAnalysis(String caseAnalysis) {
        this.caseAnalysis = caseAnalysis == null ? null : caseAnalysis.trim();
    }
}