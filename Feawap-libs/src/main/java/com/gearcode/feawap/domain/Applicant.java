package com.gearcode.feawap.domain;

import java.util.Date;

public class Applicant {
    private Integer id;

    private Integer recuitmentId;

    private String name;

    private Integer gender;

    private String cellphone;

    private String email;

    private Date graduationTime;

    private String graduateInstitutions;

    private Integer highestDegree;

    private String professional;

    private Integer experience;

    private String city;

    private String inductionTime;

    private String resumePic;

    private Date created;
    
    private Recuitment recuitment;

    public Recuitment getRecuitment() {
		return recuitment;
	}

	public void setRecuitment(Recuitment recuitment) {
		this.recuitment = recuitment;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecuitmentId() {
        return recuitmentId;
    }

    public void setRecuitmentId(Integer recuitmentId) {
        this.recuitmentId = recuitmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getGraduationTime() {
        return graduationTime;
    }

    public void setGraduationTime(Date graduationTime) {
        this.graduationTime = graduationTime;
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions == null ? null : graduateInstitutions.trim();
    }

    public Integer getHighestDegree() {
        return highestDegree;
    }

    public void setHighestDegree(Integer highestDegree) {
        this.highestDegree = highestDegree;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getInductionTime() {
        return inductionTime;
    }

    public void setInductionTime(String inductionTime) {
        this.inductionTime = inductionTime == null ? null : inductionTime.trim();
    }

    public String getResumePic() {
        return resumePic;
    }

    public void setResumePic(String resumePic) {
        this.resumePic = resumePic == null ? null : resumePic.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}