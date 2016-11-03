package com.gearcode.feawap.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrainExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return (Criteria) this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return (Criteria) this;
        }

        public Criteria andStartEqualTo(Date value) {
            addCriterion("start =", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotEqualTo(Date value) {
            addCriterion("start <>", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThan(Date value) {
            addCriterion("start >", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Date value) {
            addCriterion("start >=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThan(Date value) {
            addCriterion("start <", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartLessThanOrEqualTo(Date value) {
            addCriterion("start <=", value, "start");
            return (Criteria) this;
        }

        public Criteria andStartIn(List<Date> values) {
            addCriterion("start in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotIn(List<Date> values) {
            addCriterion("start not in", values, "start");
            return (Criteria) this;
        }

        public Criteria andStartBetween(Date value1, Date value2) {
            addCriterion("start between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andStartNotBetween(Date value1, Date value2) {
            addCriterion("start not between", value1, value2, "start");
            return (Criteria) this;
        }

        public Criteria andEndIsNull() {
            addCriterion("end is null");
            return (Criteria) this;
        }

        public Criteria andEndIsNotNull() {
            addCriterion("end is not null");
            return (Criteria) this;
        }

        public Criteria andEndEqualTo(Date value) {
            addCriterion("end =", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotEqualTo(Date value) {
            addCriterion("end <>", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThan(Date value) {
            addCriterion("end >", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndGreaterThanOrEqualTo(Date value) {
            addCriterion("end >=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThan(Date value) {
            addCriterion("end <", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndLessThanOrEqualTo(Date value) {
            addCriterion("end <=", value, "end");
            return (Criteria) this;
        }

        public Criteria andEndIn(List<Date> values) {
            addCriterion("end in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotIn(List<Date> values) {
            addCriterion("end not in", values, "end");
            return (Criteria) this;
        }

        public Criteria andEndBetween(Date value1, Date value2) {
            addCriterion("end between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andEndNotBetween(Date value1, Date value2) {
            addCriterion("end not between", value1, value2, "end");
            return (Criteria) this;
        }

        public Criteria andDaysIsNull() {
            addCriterion("days is null");
            return (Criteria) this;
        }

        public Criteria andDaysIsNotNull() {
            addCriterion("days is not null");
            return (Criteria) this;
        }

        public Criteria andDaysEqualTo(Integer value) {
            addCriterion("days =", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotEqualTo(Integer value) {
            addCriterion("days <>", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThan(Integer value) {
            addCriterion("days >", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("days >=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThan(Integer value) {
            addCriterion("days <", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysLessThanOrEqualTo(Integer value) {
            addCriterion("days <=", value, "days");
            return (Criteria) this;
        }

        public Criteria andDaysIn(List<Integer> values) {
            addCriterion("days in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotIn(List<Integer> values) {
            addCriterion("days not in", values, "days");
            return (Criteria) this;
        }

        public Criteria andDaysBetween(Integer value1, Integer value2) {
            addCriterion("days between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("days not between", value1, value2, "days");
            return (Criteria) this;
        }

        public Criteria andPeoplesIsNull() {
            addCriterion("peoples is null");
            return (Criteria) this;
        }

        public Criteria andPeoplesIsNotNull() {
            addCriterion("peoples is not null");
            return (Criteria) this;
        }

        public Criteria andPeoplesEqualTo(Integer value) {
            addCriterion("peoples =", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesNotEqualTo(Integer value) {
            addCriterion("peoples <>", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesGreaterThan(Integer value) {
            addCriterion("peoples >", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesGreaterThanOrEqualTo(Integer value) {
            addCriterion("peoples >=", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesLessThan(Integer value) {
            addCriterion("peoples <", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesLessThanOrEqualTo(Integer value) {
            addCriterion("peoples <=", value, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesIn(List<Integer> values) {
            addCriterion("peoples in", values, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesNotIn(List<Integer> values) {
            addCriterion("peoples not in", values, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesBetween(Integer value1, Integer value2) {
            addCriterion("peoples between", value1, value2, "peoples");
            return (Criteria) this;
        }

        public Criteria andPeoplesNotBetween(Integer value1, Integer value2) {
            addCriterion("peoples not between", value1, value2, "peoples");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Integer value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Integer value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Integer value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Integer value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Integer value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Integer> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Integer> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Integer value1, Integer value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Integer value1, Integer value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andPositionTitleIsNull() {
            addCriterion("position_title is null");
            return (Criteria) this;
        }

        public Criteria andPositionTitleIsNotNull() {
            addCriterion("position_title is not null");
            return (Criteria) this;
        }

        public Criteria andPositionTitleEqualTo(String value) {
            addCriterion("position_title =", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleNotEqualTo(String value) {
            addCriterion("position_title <>", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleGreaterThan(String value) {
            addCriterion("position_title >", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("position_title >=", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleLessThan(String value) {
            addCriterion("position_title <", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleLessThanOrEqualTo(String value) {
            addCriterion("position_title <=", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleLike(String value) {
            addCriterion("position_title like", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleNotLike(String value) {
            addCriterion("position_title not like", value, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleIn(List<String> values) {
            addCriterion("position_title in", values, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleNotIn(List<String> values) {
            addCriterion("position_title not in", values, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleBetween(String value1, String value2) {
            addCriterion("position_title between", value1, value2, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionTitleNotBetween(String value1, String value2) {
            addCriterion("position_title not between", value1, value2, "positionTitle");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIsNull() {
            addCriterion("position_description is null");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIsNotNull() {
            addCriterion("position_description is not null");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionEqualTo(String value) {
            addCriterion("position_description =", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotEqualTo(String value) {
            addCriterion("position_description <>", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionGreaterThan(String value) {
            addCriterion("position_description >", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("position_description >=", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLessThan(String value) {
            addCriterion("position_description <", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("position_description <=", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionLike(String value) {
            addCriterion("position_description like", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotLike(String value) {
            addCriterion("position_description not like", value, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionIn(List<String> values) {
            addCriterion("position_description in", values, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotIn(List<String> values) {
            addCriterion("position_description not in", values, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionBetween(String value1, String value2) {
            addCriterion("position_description between", value1, value2, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionDescriptionNotBetween(String value1, String value2) {
            addCriterion("position_description not between", value1, value2, "positionDescription");
            return (Criteria) this;
        }

        public Criteria andPositionLatIsNull() {
            addCriterion("position_lat is null");
            return (Criteria) this;
        }

        public Criteria andPositionLatIsNotNull() {
            addCriterion("position_lat is not null");
            return (Criteria) this;
        }

        public Criteria andPositionLatEqualTo(Double value) {
            addCriterion("position_lat =", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatNotEqualTo(Double value) {
            addCriterion("position_lat <>", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatGreaterThan(Double value) {
            addCriterion("position_lat >", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatGreaterThanOrEqualTo(Double value) {
            addCriterion("position_lat >=", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatLessThan(Double value) {
            addCriterion("position_lat <", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatLessThanOrEqualTo(Double value) {
            addCriterion("position_lat <=", value, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatIn(List<Double> values) {
            addCriterion("position_lat in", values, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatNotIn(List<Double> values) {
            addCriterion("position_lat not in", values, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatBetween(Double value1, Double value2) {
            addCriterion("position_lat between", value1, value2, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLatNotBetween(Double value1, Double value2) {
            addCriterion("position_lat not between", value1, value2, "positionLat");
            return (Criteria) this;
        }

        public Criteria andPositionLngIsNull() {
            addCriterion("position_lng is null");
            return (Criteria) this;
        }

        public Criteria andPositionLngIsNotNull() {
            addCriterion("position_lng is not null");
            return (Criteria) this;
        }

        public Criteria andPositionLngEqualTo(Double value) {
            addCriterion("position_lng =", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngNotEqualTo(Double value) {
            addCriterion("position_lng <>", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngGreaterThan(Double value) {
            addCriterion("position_lng >", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngGreaterThanOrEqualTo(Double value) {
            addCriterion("position_lng >=", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngLessThan(Double value) {
            addCriterion("position_lng <", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngLessThanOrEqualTo(Double value) {
            addCriterion("position_lng <=", value, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngIn(List<Double> values) {
            addCriterion("position_lng in", values, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngNotIn(List<Double> values) {
            addCriterion("position_lng not in", values, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngBetween(Double value1, Double value2) {
            addCriterion("position_lng between", value1, value2, "positionLng");
            return (Criteria) this;
        }

        public Criteria andPositionLngNotBetween(Double value1, Double value2) {
            addCriterion("position_lng not between", value1, value2, "positionLng");
            return (Criteria) this;
        }

        public Criteria andHotelsIsNull() {
            addCriterion("hotels is null");
            return (Criteria) this;
        }

        public Criteria andHotelsIsNotNull() {
            addCriterion("hotels is not null");
            return (Criteria) this;
        }

        public Criteria andHotelsEqualTo(String value) {
            addCriterion("hotels =", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsNotEqualTo(String value) {
            addCriterion("hotels <>", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsGreaterThan(String value) {
            addCriterion("hotels >", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsGreaterThanOrEqualTo(String value) {
            addCriterion("hotels >=", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsLessThan(String value) {
            addCriterion("hotels <", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsLessThanOrEqualTo(String value) {
            addCriterion("hotels <=", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsLike(String value) {
            addCriterion("hotels like", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsNotLike(String value) {
            addCriterion("hotels not like", value, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsIn(List<String> values) {
            addCriterion("hotels in", values, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsNotIn(List<String> values) {
            addCriterion("hotels not in", values, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsBetween(String value1, String value2) {
            addCriterion("hotels between", value1, value2, "hotels");
            return (Criteria) this;
        }

        public Criteria andHotelsNotBetween(String value1, String value2) {
            addCriterion("hotels not between", value1, value2, "hotels");
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