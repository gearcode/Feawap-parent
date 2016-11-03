package com.gearcode.feawap.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicantExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdIsNull() {
            addCriterion("recuitment_id is null");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdIsNotNull() {
            addCriterion("recuitment_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdEqualTo(Integer value) {
            addCriterion("recuitment_id =", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdNotEqualTo(Integer value) {
            addCriterion("recuitment_id <>", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdGreaterThan(Integer value) {
            addCriterion("recuitment_id >", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("recuitment_id >=", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdLessThan(Integer value) {
            addCriterion("recuitment_id <", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("recuitment_id <=", value, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdIn(List<Integer> values) {
            addCriterion("recuitment_id in", values, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdNotIn(List<Integer> values) {
            addCriterion("recuitment_id not in", values, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdBetween(Integer value1, Integer value2) {
            addCriterion("recuitment_id between", value1, value2, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andRecuitmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("recuitment_id not between", value1, value2, "recuitmentId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNull() {
            addCriterion("cellphone is null");
            return (Criteria) this;
        }

        public Criteria andCellphoneIsNotNull() {
            addCriterion("cellphone is not null");
            return (Criteria) this;
        }

        public Criteria andCellphoneEqualTo(String value) {
            addCriterion("cellphone =", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotEqualTo(String value) {
            addCriterion("cellphone <>", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThan(String value) {
            addCriterion("cellphone >", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cellphone >=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThan(String value) {
            addCriterion("cellphone <", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLessThanOrEqualTo(String value) {
            addCriterion("cellphone <=", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneLike(String value) {
            addCriterion("cellphone like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotLike(String value) {
            addCriterion("cellphone not like", value, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneIn(List<String> values) {
            addCriterion("cellphone in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotIn(List<String> values) {
            addCriterion("cellphone not in", values, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneBetween(String value1, String value2) {
            addCriterion("cellphone between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andCellphoneNotBetween(String value1, String value2) {
            addCriterion("cellphone not between", value1, value2, "cellphone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNull() {
            addCriterion("graduation_time is null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIsNotNull() {
            addCriterion("graduation_time is not null");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeEqualTo(Date value) {
            addCriterion("graduation_time =", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotEqualTo(Date value) {
            addCriterion("graduation_time <>", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThan(Date value) {
            addCriterion("graduation_time >", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("graduation_time >=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThan(Date value) {
            addCriterion("graduation_time <", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeLessThanOrEqualTo(Date value) {
            addCriterion("graduation_time <=", value, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeIn(List<Date> values) {
            addCriterion("graduation_time in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotIn(List<Date> values) {
            addCriterion("graduation_time not in", values, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeBetween(Date value1, Date value2) {
            addCriterion("graduation_time between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduationTimeNotBetween(Date value1, Date value2) {
            addCriterion("graduation_time not between", value1, value2, "graduationTime");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIsNull() {
            addCriterion("graduate_institutions is null");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIsNotNull() {
            addCriterion("graduate_institutions is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsEqualTo(String value) {
            addCriterion("graduate_institutions =", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotEqualTo(String value) {
            addCriterion("graduate_institutions <>", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsGreaterThan(String value) {
            addCriterion("graduate_institutions >", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_institutions >=", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLessThan(String value) {
            addCriterion("graduate_institutions <", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLessThanOrEqualTo(String value) {
            addCriterion("graduate_institutions <=", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsLike(String value) {
            addCriterion("graduate_institutions like", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotLike(String value) {
            addCriterion("graduate_institutions not like", value, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsIn(List<String> values) {
            addCriterion("graduate_institutions in", values, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotIn(List<String> values) {
            addCriterion("graduate_institutions not in", values, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsBetween(String value1, String value2) {
            addCriterion("graduate_institutions between", value1, value2, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andGraduateInstitutionsNotBetween(String value1, String value2) {
            addCriterion("graduate_institutions not between", value1, value2, "graduateInstitutions");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeIsNull() {
            addCriterion("highest_degree is null");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeIsNotNull() {
            addCriterion("highest_degree is not null");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeEqualTo(Integer value) {
            addCriterion("highest_degree =", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeNotEqualTo(Integer value) {
            addCriterion("highest_degree <>", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeGreaterThan(Integer value) {
            addCriterion("highest_degree >", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("highest_degree >=", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeLessThan(Integer value) {
            addCriterion("highest_degree <", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("highest_degree <=", value, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeIn(List<Integer> values) {
            addCriterion("highest_degree in", values, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeNotIn(List<Integer> values) {
            addCriterion("highest_degree not in", values, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeBetween(Integer value1, Integer value2) {
            addCriterion("highest_degree between", value1, value2, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andHighestDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("highest_degree not between", value1, value2, "highestDegree");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNull() {
            addCriterion("professional is null");
            return (Criteria) this;
        }

        public Criteria andProfessionalIsNotNull() {
            addCriterion("professional is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionalEqualTo(String value) {
            addCriterion("professional =", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotEqualTo(String value) {
            addCriterion("professional <>", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThan(String value) {
            addCriterion("professional >", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalGreaterThanOrEqualTo(String value) {
            addCriterion("professional >=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThan(String value) {
            addCriterion("professional <", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLessThanOrEqualTo(String value) {
            addCriterion("professional <=", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalLike(String value) {
            addCriterion("professional like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotLike(String value) {
            addCriterion("professional not like", value, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalIn(List<String> values) {
            addCriterion("professional in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotIn(List<String> values) {
            addCriterion("professional not in", values, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalBetween(String value1, String value2) {
            addCriterion("professional between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andProfessionalNotBetween(String value1, String value2) {
            addCriterion("professional not between", value1, value2, "professional");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNull() {
            addCriterion("experience is null");
            return (Criteria) this;
        }

        public Criteria andExperienceIsNotNull() {
            addCriterion("experience is not null");
            return (Criteria) this;
        }

        public Criteria andExperienceEqualTo(Integer value) {
            addCriterion("experience =", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotEqualTo(Integer value) {
            addCriterion("experience <>", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThan(Integer value) {
            addCriterion("experience >", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("experience >=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThan(Integer value) {
            addCriterion("experience <", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceLessThanOrEqualTo(Integer value) {
            addCriterion("experience <=", value, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceIn(List<Integer> values) {
            addCriterion("experience in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotIn(List<Integer> values) {
            addCriterion("experience not in", values, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceBetween(Integer value1, Integer value2) {
            addCriterion("experience between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andExperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("experience not between", value1, value2, "experience");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andInductionTimeIsNull() {
            addCriterion("induction_time is null");
            return (Criteria) this;
        }

        public Criteria andInductionTimeIsNotNull() {
            addCriterion("induction_time is not null");
            return (Criteria) this;
        }

        public Criteria andInductionTimeEqualTo(String value) {
            addCriterion("induction_time =", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeNotEqualTo(String value) {
            addCriterion("induction_time <>", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeGreaterThan(String value) {
            addCriterion("induction_time >", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeGreaterThanOrEqualTo(String value) {
            addCriterion("induction_time >=", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeLessThan(String value) {
            addCriterion("induction_time <", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeLessThanOrEqualTo(String value) {
            addCriterion("induction_time <=", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeLike(String value) {
            addCriterion("induction_time like", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeNotLike(String value) {
            addCriterion("induction_time not like", value, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeIn(List<String> values) {
            addCriterion("induction_time in", values, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeNotIn(List<String> values) {
            addCriterion("induction_time not in", values, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeBetween(String value1, String value2) {
            addCriterion("induction_time between", value1, value2, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andInductionTimeNotBetween(String value1, String value2) {
            addCriterion("induction_time not between", value1, value2, "inductionTime");
            return (Criteria) this;
        }

        public Criteria andResumePicIsNull() {
            addCriterion("resume_pic is null");
            return (Criteria) this;
        }

        public Criteria andResumePicIsNotNull() {
            addCriterion("resume_pic is not null");
            return (Criteria) this;
        }

        public Criteria andResumePicEqualTo(String value) {
            addCriterion("resume_pic =", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicNotEqualTo(String value) {
            addCriterion("resume_pic <>", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicGreaterThan(String value) {
            addCriterion("resume_pic >", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicGreaterThanOrEqualTo(String value) {
            addCriterion("resume_pic >=", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicLessThan(String value) {
            addCriterion("resume_pic <", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicLessThanOrEqualTo(String value) {
            addCriterion("resume_pic <=", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicLike(String value) {
            addCriterion("resume_pic like", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicNotLike(String value) {
            addCriterion("resume_pic not like", value, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicIn(List<String> values) {
            addCriterion("resume_pic in", values, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicNotIn(List<String> values) {
            addCriterion("resume_pic not in", values, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicBetween(String value1, String value2) {
            addCriterion("resume_pic between", value1, value2, "resumePic");
            return (Criteria) this;
        }

        public Criteria andResumePicNotBetween(String value1, String value2) {
            addCriterion("resume_pic not between", value1, value2, "resumePic");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}