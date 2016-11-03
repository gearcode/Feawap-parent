package com.gearcode.feawap.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeedbackCourseOpinionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackCourseOpinionExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(Integer value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(Integer value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(Integer value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(Integer value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(Integer value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(Integer value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<Integer> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<Integer> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(Integer value1, Integer value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(Integer value1, Integer value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andExplicitIsNull() {
            addCriterion("explicit is null");
            return (Criteria) this;
        }

        public Criteria andExplicitIsNotNull() {
            addCriterion("explicit is not null");
            return (Criteria) this;
        }

        public Criteria andExplicitEqualTo(Integer value) {
            addCriterion("explicit =", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitNotEqualTo(Integer value) {
            addCriterion("explicit <>", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitGreaterThan(Integer value) {
            addCriterion("explicit >", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitGreaterThanOrEqualTo(Integer value) {
            addCriterion("explicit >=", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitLessThan(Integer value) {
            addCriterion("explicit <", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitLessThanOrEqualTo(Integer value) {
            addCriterion("explicit <=", value, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitIn(List<Integer> values) {
            addCriterion("explicit in", values, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitNotIn(List<Integer> values) {
            addCriterion("explicit not in", values, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitBetween(Integer value1, Integer value2) {
            addCriterion("explicit between", value1, value2, "explicit");
            return (Criteria) this;
        }

        public Criteria andExplicitNotBetween(Integer value1, Integer value2) {
            addCriterion("explicit not between", value1, value2, "explicit");
            return (Criteria) this;
        }

        public Criteria andInterestingIsNull() {
            addCriterion("interesting is null");
            return (Criteria) this;
        }

        public Criteria andInterestingIsNotNull() {
            addCriterion("interesting is not null");
            return (Criteria) this;
        }

        public Criteria andInterestingEqualTo(String value) {
            addCriterion("interesting =", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingNotEqualTo(String value) {
            addCriterion("interesting <>", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingGreaterThan(String value) {
            addCriterion("interesting >", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingGreaterThanOrEqualTo(String value) {
            addCriterion("interesting >=", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingLessThan(String value) {
            addCriterion("interesting <", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingLessThanOrEqualTo(String value) {
            addCriterion("interesting <=", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingLike(String value) {
            addCriterion("interesting like", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingNotLike(String value) {
            addCriterion("interesting not like", value, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingIn(List<String> values) {
            addCriterion("interesting in", values, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingNotIn(List<String> values) {
            addCriterion("interesting not in", values, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingBetween(String value1, String value2) {
            addCriterion("interesting between", value1, value2, "interesting");
            return (Criteria) this;
        }

        public Criteria andInterestingNotBetween(String value1, String value2) {
            addCriterion("interesting not between", value1, value2, "interesting");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationIsNull() {
            addCriterion("lecturer_plan_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationIsNotNull() {
            addCriterion("lecturer_plan_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationEqualTo(String value) {
            addCriterion("lecturer_plan_evaluation =", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationNotEqualTo(String value) {
            addCriterion("lecturer_plan_evaluation <>", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationGreaterThan(String value) {
            addCriterion("lecturer_plan_evaluation >", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("lecturer_plan_evaluation >=", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationLessThan(String value) {
            addCriterion("lecturer_plan_evaluation <", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationLessThanOrEqualTo(String value) {
            addCriterion("lecturer_plan_evaluation <=", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationLike(String value) {
            addCriterion("lecturer_plan_evaluation like", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationNotLike(String value) {
            addCriterion("lecturer_plan_evaluation not like", value, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationIn(List<String> values) {
            addCriterion("lecturer_plan_evaluation in", values, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationNotIn(List<String> values) {
            addCriterion("lecturer_plan_evaluation not in", values, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationBetween(String value1, String value2) {
            addCriterion("lecturer_plan_evaluation between", value1, value2, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerPlanEvaluationNotBetween(String value1, String value2) {
            addCriterion("lecturer_plan_evaluation not between", value1, value2, "lecturerPlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCommunicationIsNull() {
            addCriterion("communication is null");
            return (Criteria) this;
        }

        public Criteria andCommunicationIsNotNull() {
            addCriterion("communication is not null");
            return (Criteria) this;
        }

        public Criteria andCommunicationEqualTo(Integer value) {
            addCriterion("communication =", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationNotEqualTo(Integer value) {
            addCriterion("communication <>", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationGreaterThan(Integer value) {
            addCriterion("communication >", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationGreaterThanOrEqualTo(Integer value) {
            addCriterion("communication >=", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationLessThan(Integer value) {
            addCriterion("communication <", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationLessThanOrEqualTo(Integer value) {
            addCriterion("communication <=", value, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationIn(List<Integer> values) {
            addCriterion("communication in", values, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationNotIn(List<Integer> values) {
            addCriterion("communication not in", values, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationBetween(Integer value1, Integer value2) {
            addCriterion("communication between", value1, value2, "communication");
            return (Criteria) this;
        }

        public Criteria andCommunicationNotBetween(Integer value1, Integer value2) {
            addCriterion("communication not between", value1, value2, "communication");
            return (Criteria) this;
        }

        public Criteria andPrepareIsNull() {
            addCriterion("prepare is null");
            return (Criteria) this;
        }

        public Criteria andPrepareIsNotNull() {
            addCriterion("prepare is not null");
            return (Criteria) this;
        }

        public Criteria andPrepareEqualTo(Integer value) {
            addCriterion("prepare =", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareNotEqualTo(Integer value) {
            addCriterion("prepare <>", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareGreaterThan(Integer value) {
            addCriterion("prepare >", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareGreaterThanOrEqualTo(Integer value) {
            addCriterion("prepare >=", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareLessThan(Integer value) {
            addCriterion("prepare <", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareLessThanOrEqualTo(Integer value) {
            addCriterion("prepare <=", value, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareIn(List<Integer> values) {
            addCriterion("prepare in", values, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareNotIn(List<Integer> values) {
            addCriterion("prepare not in", values, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareBetween(Integer value1, Integer value2) {
            addCriterion("prepare between", value1, value2, "prepare");
            return (Criteria) this;
        }

        public Criteria andPrepareNotBetween(Integer value1, Integer value2) {
            addCriterion("prepare not between", value1, value2, "prepare");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNull() {
            addCriterion("attitude is null");
            return (Criteria) this;
        }

        public Criteria andAttitudeIsNotNull() {
            addCriterion("attitude is not null");
            return (Criteria) this;
        }

        public Criteria andAttitudeEqualTo(Integer value) {
            addCriterion("attitude =", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotEqualTo(Integer value) {
            addCriterion("attitude <>", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThan(Integer value) {
            addCriterion("attitude >", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeGreaterThanOrEqualTo(Integer value) {
            addCriterion("attitude >=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThan(Integer value) {
            addCriterion("attitude <", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeLessThanOrEqualTo(Integer value) {
            addCriterion("attitude <=", value, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeIn(List<Integer> values) {
            addCriterion("attitude in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotIn(List<Integer> values) {
            addCriterion("attitude not in", values, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeBetween(Integer value1, Integer value2) {
            addCriterion("attitude between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andAttitudeNotBetween(Integer value1, Integer value2) {
            addCriterion("attitude not between", value1, value2, "attitude");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationIsNull() {
            addCriterion("lecturer_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationIsNotNull() {
            addCriterion("lecturer_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationEqualTo(String value) {
            addCriterion("lecturer_evaluation =", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationNotEqualTo(String value) {
            addCriterion("lecturer_evaluation <>", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationGreaterThan(String value) {
            addCriterion("lecturer_evaluation >", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("lecturer_evaluation >=", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationLessThan(String value) {
            addCriterion("lecturer_evaluation <", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationLessThanOrEqualTo(String value) {
            addCriterion("lecturer_evaluation <=", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationLike(String value) {
            addCriterion("lecturer_evaluation like", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationNotLike(String value) {
            addCriterion("lecturer_evaluation not like", value, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationIn(List<String> values) {
            addCriterion("lecturer_evaluation in", values, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationNotIn(List<String> values) {
            addCriterion("lecturer_evaluation not in", values, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationBetween(String value1, String value2) {
            addCriterion("lecturer_evaluation between", value1, value2, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andLecturerEvaluationNotBetween(String value1, String value2) {
            addCriterion("lecturer_evaluation not between", value1, value2, "lecturerEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationIsNull() {
            addCriterion("course_plan_evaluation is null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationIsNotNull() {
            addCriterion("course_plan_evaluation is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationEqualTo(String value) {
            addCriterion("course_plan_evaluation =", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationNotEqualTo(String value) {
            addCriterion("course_plan_evaluation <>", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationGreaterThan(String value) {
            addCriterion("course_plan_evaluation >", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationGreaterThanOrEqualTo(String value) {
            addCriterion("course_plan_evaluation >=", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationLessThan(String value) {
            addCriterion("course_plan_evaluation <", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationLessThanOrEqualTo(String value) {
            addCriterion("course_plan_evaluation <=", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationLike(String value) {
            addCriterion("course_plan_evaluation like", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationNotLike(String value) {
            addCriterion("course_plan_evaluation not like", value, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationIn(List<String> values) {
            addCriterion("course_plan_evaluation in", values, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationNotIn(List<String> values) {
            addCriterion("course_plan_evaluation not in", values, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationBetween(String value1, String value2) {
            addCriterion("course_plan_evaluation between", value1, value2, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andCoursePlanEvaluationNotBetween(String value1, String value2) {
            addCriterion("course_plan_evaluation not between", value1, value2, "coursePlanEvaluation");
            return (Criteria) this;
        }

        public Criteria andAttendIsNull() {
            addCriterion("attend is null");
            return (Criteria) this;
        }

        public Criteria andAttendIsNotNull() {
            addCriterion("attend is not null");
            return (Criteria) this;
        }

        public Criteria andAttendEqualTo(String value) {
            addCriterion("attend =", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotEqualTo(String value) {
            addCriterion("attend <>", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendGreaterThan(String value) {
            addCriterion("attend >", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendGreaterThanOrEqualTo(String value) {
            addCriterion("attend >=", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendLessThan(String value) {
            addCriterion("attend <", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendLessThanOrEqualTo(String value) {
            addCriterion("attend <=", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendLike(String value) {
            addCriterion("attend like", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotLike(String value) {
            addCriterion("attend not like", value, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendIn(List<String> values) {
            addCriterion("attend in", values, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotIn(List<String> values) {
            addCriterion("attend not in", values, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendBetween(String value1, String value2) {
            addCriterion("attend between", value1, value2, "attend");
            return (Criteria) this;
        }

        public Criteria andAttendNotBetween(String value1, String value2) {
            addCriterion("attend not between", value1, value2, "attend");
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