package com.gearcode.feawap.domain;

import java.util.Date;

public class FeedbackCourseOpinion {
    private Integer id;

    private Integer userId;

    private Integer content;

    private Integer explicit;

    private String interesting;

    private String lecturerPlanEvaluation;

    private Integer communication;

    private Integer prepare;

    private Integer attitude;

    private String lecturerEvaluation;

    private String coursePlanEvaluation;

    private String attend;

    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContent() {
        return content;
    }

    public void setContent(Integer content) {
        this.content = content;
    }

    public Integer getExplicit() {
        return explicit;
    }

    public void setExplicit(Integer explicit) {
        this.explicit = explicit;
    }

    public String getInteresting() {
        return interesting;
    }

    public void setInteresting(String interesting) {
        this.interesting = interesting == null ? null : interesting.trim();
    }

    public String getLecturerPlanEvaluation() {
        return lecturerPlanEvaluation;
    }

    public void setLecturerPlanEvaluation(String lecturerPlanEvaluation) {
        this.lecturerPlanEvaluation = lecturerPlanEvaluation == null ? null : lecturerPlanEvaluation.trim();
    }

    public Integer getCommunication() {
        return communication;
    }

    public void setCommunication(Integer communication) {
        this.communication = communication;
    }

    public Integer getPrepare() {
        return prepare;
    }

    public void setPrepare(Integer prepare) {
        this.prepare = prepare;
    }

    public Integer getAttitude() {
        return attitude;
    }

    public void setAttitude(Integer attitude) {
        this.attitude = attitude;
    }

    public String getLecturerEvaluation() {
        return lecturerEvaluation;
    }

    public void setLecturerEvaluation(String lecturerEvaluation) {
        this.lecturerEvaluation = lecturerEvaluation == null ? null : lecturerEvaluation.trim();
    }

    public String getCoursePlanEvaluation() {
        return coursePlanEvaluation;
    }

    public void setCoursePlanEvaluation(String coursePlanEvaluation) {
        this.coursePlanEvaluation = coursePlanEvaluation == null ? null : coursePlanEvaluation.trim();
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend == null ? null : attend.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}