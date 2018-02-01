package cn.xc.dao.condition;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
/**
 * @Description: 违章信息条件查询类
 * 
 * @Author XiongCheng 
 * @version V1.0
 * @Date 2018/1/30 12:23.
 */
public class ViolatingInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public ViolatingInformationExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNull() {
            addCriterion("identifier is null");
            return (Criteria) this;
        }

        public Criteria andIdentifierIsNotNull() {
            addCriterion("identifier is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifierEqualTo(String value) {
            addCriterion("identifier =", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotEqualTo(String value) {
            addCriterion("identifier <>", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThan(String value) {
            addCriterion("identifier >", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierGreaterThanOrEqualTo(String value) {
            addCriterion("identifier >=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThan(String value) {
            addCriterion("identifier <", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLessThanOrEqualTo(String value) {
            addCriterion("identifier <=", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierLike(String value) {
            addCriterion("identifier like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotLike(String value) {
            addCriterion("identifier not like", value, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierIn(List<String> values) {
            addCriterion("identifier in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotIn(List<String> values) {
            addCriterion("identifier not in", values, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierBetween(String value1, String value2) {
            addCriterion("identifier between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andIdentifierNotBetween(String value1, String value2) {
            addCriterion("identifier not between", value1, value2, "identifier");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIsNull() {
            addCriterion("violation_type is null");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIsNotNull() {
            addCriterion("violation_type is not null");
            return (Criteria) this;
        }

        public Criteria andViolationTypeEqualTo(Integer value) {
            addCriterion("violation_type =", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotEqualTo(Integer value) {
            addCriterion("violation_type <>", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeGreaterThan(Integer value) {
            addCriterion("violation_type >", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("violation_type >=", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeLessThan(Integer value) {
            addCriterion("violation_type <", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeLessThanOrEqualTo(Integer value) {
            addCriterion("violation_type <=", value, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeIn(List<Integer> values) {
            addCriterion("violation_type in", values, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotIn(List<Integer> values) {
            addCriterion("violation_type not in", values, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeBetween(Integer value1, Integer value2) {
            addCriterion("violation_type between", value1, value2, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("violation_type not between", value1, value2, "violationType");
            return (Criteria) this;
        }

        public Criteria andViolationTimeIsNull() {
            addCriterion("violation_time is null");
            return (Criteria) this;
        }

        public Criteria andViolationTimeIsNotNull() {
            addCriterion("violation_time is not null");
            return (Criteria) this;
        }

        public Criteria andViolationTimeEqualTo(Timestamp value) {
            addCriterion("violation_time =", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeNotEqualTo(Timestamp value) {
            addCriterion("violation_time <>", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeGreaterThan(Timestamp value) {
            addCriterion("violation_time >", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("violation_time >=", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeLessThan(Timestamp value) {
            addCriterion("violation_time <", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("violation_time <=", value, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeIn(List<Timestamp> values) {
            addCriterion("violation_time in", values, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeNotIn(List<Timestamp> values) {
            addCriterion("violation_time not in", values, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("violation_time between", value1, value2, "violationTime");
            return (Criteria) this;
        }

        public Criteria andViolationTimeNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("violation_time not between", value1, value2, "violationTime");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointIsNull() {
            addCriterion("penalty_point is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointIsNotNull() {
            addCriterion("penalty_point is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointEqualTo(Integer value) {
            addCriterion("penalty_point =", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointNotEqualTo(Integer value) {
            addCriterion("penalty_point <>", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointGreaterThan(Integer value) {
            addCriterion("penalty_point >", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointGreaterThanOrEqualTo(Integer value) {
            addCriterion("penalty_point >=", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointLessThan(Integer value) {
            addCriterion("penalty_point <", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointLessThanOrEqualTo(Integer value) {
            addCriterion("penalty_point <=", value, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointIn(List<Integer> values) {
            addCriterion("penalty_point in", values, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointNotIn(List<Integer> values) {
            addCriterion("penalty_point not in", values, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointBetween(Integer value1, Integer value2) {
            addCriterion("penalty_point between", value1, value2, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyPointNotBetween(Integer value1, Integer value2) {
            addCriterion("penalty_point not between", value1, value2, "penaltyPoint");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIsNull() {
            addCriterion("penalty_money is null");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIsNotNull() {
            addCriterion("penalty_money is not null");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyEqualTo(BigDecimal value) {
            addCriterion("penalty_money =", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("penalty_money <>", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyGreaterThan(BigDecimal value) {
            addCriterion("penalty_money >", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("penalty_money >=", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyLessThan(BigDecimal value) {
            addCriterion("penalty_money <", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("penalty_money <=", value, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyIn(List<BigDecimal> values) {
            addCriterion("penalty_money in", values, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("penalty_money not in", values, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("penalty_money between", value1, value2, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andPenaltyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("penalty_money not between", value1, value2, "penaltyMoney");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Timestamp value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Timestamp value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Timestamp value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Timestamp value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Timestamp> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Timestamp> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Timestamp value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Timestamp value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Timestamp value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Timestamp value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Timestamp value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Timestamp> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Timestamp> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Timestamp value1, Timestamp value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    /**
     */
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