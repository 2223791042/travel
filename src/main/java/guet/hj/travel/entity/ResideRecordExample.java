package guet.hj.travel.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResideRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResideRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andResideIdIsNull() {
            addCriterion("reside_id is null");
            return (Criteria) this;
        }

        public Criteria andResideIdIsNotNull() {
            addCriterion("reside_id is not null");
            return (Criteria) this;
        }

        public Criteria andResideIdEqualTo(Long value) {
            addCriterion("reside_id =", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdNotEqualTo(Long value) {
            addCriterion("reside_id <>", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdGreaterThan(Long value) {
            addCriterion("reside_id >", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reside_id >=", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdLessThan(Long value) {
            addCriterion("reside_id <", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdLessThanOrEqualTo(Long value) {
            addCriterion("reside_id <=", value, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdIn(List<Long> values) {
            addCriterion("reside_id in", values, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdNotIn(List<Long> values) {
            addCriterion("reside_id not in", values, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdBetween(Long value1, Long value2) {
            addCriterion("reside_id between", value1, value2, "resideId");
            return (Criteria) this;
        }

        public Criteria andResideIdNotBetween(Long value1, Long value2) {
            addCriterion("reside_id not between", value1, value2, "resideId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdIsNull() {
            addCriterion("consumer_id is null");
            return (Criteria) this;
        }

        public Criteria andConsumerIdIsNotNull() {
            addCriterion("consumer_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsumerIdEqualTo(Long value) {
            addCriterion("consumer_id =", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdNotEqualTo(Long value) {
            addCriterion("consumer_id <>", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdGreaterThan(Long value) {
            addCriterion("consumer_id >", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("consumer_id >=", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdLessThan(Long value) {
            addCriterion("consumer_id <", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdLessThanOrEqualTo(Long value) {
            addCriterion("consumer_id <=", value, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdIn(List<Long> values) {
            addCriterion("consumer_id in", values, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdNotIn(List<Long> values) {
            addCriterion("consumer_id not in", values, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdBetween(Long value1, Long value2) {
            addCriterion("consumer_id between", value1, value2, "consumerId");
            return (Criteria) this;
        }

        public Criteria andConsumerIdNotBetween(Long value1, Long value2) {
            addCriterion("consumer_id not between", value1, value2, "consumerId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNull() {
            addCriterion("in_time is null");
            return (Criteria) this;
        }

        public Criteria andInTimeIsNotNull() {
            addCriterion("in_time is not null");
            return (Criteria) this;
        }

        public Criteria andInTimeEqualTo(Date value) {
            addCriterionForJDBCDate("in_time =", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("in_time <>", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("in_time >", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_time >=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThan(Date value) {
            addCriterionForJDBCDate("in_time <", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("in_time <=", value, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeIn(List<Date> values) {
            addCriterionForJDBCDate("in_time in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("in_time not in", values, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_time between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andInTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("in_time not between", value1, value2, "inTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNull() {
            addCriterion("out_time is null");
            return (Criteria) this;
        }

        public Criteria andOutTimeIsNotNull() {
            addCriterion("out_time is not null");
            return (Criteria) this;
        }

        public Criteria andOutTimeEqualTo(Date value) {
            addCriterionForJDBCDate("out_time =", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("out_time <>", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("out_time >", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_time >=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThan(Date value) {
            addCriterionForJDBCDate("out_time <", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("out_time <=", value, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeIn(List<Date> values) {
            addCriterionForJDBCDate("out_time in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("out_time not in", values, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_time between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andOutTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("out_time not between", value1, value2, "outTime");
            return (Criteria) this;
        }

        public Criteria andResideDaysIsNull() {
            addCriterion("reside_days is null");
            return (Criteria) this;
        }

        public Criteria andResideDaysIsNotNull() {
            addCriterion("reside_days is not null");
            return (Criteria) this;
        }

        public Criteria andResideDaysEqualTo(Integer value) {
            addCriterion("reside_days =", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysNotEqualTo(Integer value) {
            addCriterion("reside_days <>", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysGreaterThan(Integer value) {
            addCriterion("reside_days >", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("reside_days >=", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysLessThan(Integer value) {
            addCriterion("reside_days <", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysLessThanOrEqualTo(Integer value) {
            addCriterion("reside_days <=", value, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysIn(List<Integer> values) {
            addCriterion("reside_days in", values, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysNotIn(List<Integer> values) {
            addCriterion("reside_days not in", values, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysBetween(Integer value1, Integer value2) {
            addCriterion("reside_days between", value1, value2, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("reside_days not between", value1, value2, "resideDays");
            return (Criteria) this;
        }

        public Criteria andResideCostIsNull() {
            addCriterion("reside_cost is null");
            return (Criteria) this;
        }

        public Criteria andResideCostIsNotNull() {
            addCriterion("reside_cost is not null");
            return (Criteria) this;
        }

        public Criteria andResideCostEqualTo(BigDecimal value) {
            addCriterion("reside_cost =", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostNotEqualTo(BigDecimal value) {
            addCriterion("reside_cost <>", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostGreaterThan(BigDecimal value) {
            addCriterion("reside_cost >", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reside_cost >=", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostLessThan(BigDecimal value) {
            addCriterion("reside_cost <", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reside_cost <=", value, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostIn(List<BigDecimal> values) {
            addCriterion("reside_cost in", values, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostNotIn(List<BigDecimal> values) {
            addCriterion("reside_cost not in", values, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reside_cost between", value1, value2, "resideCost");
            return (Criteria) this;
        }

        public Criteria andResideCostNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reside_cost not between", value1, value2, "resideCost");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Date value) {
            addCriterionForJDBCDate("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Date value) {
            addCriterionForJDBCDate("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Date> values) {
            addCriterionForJDBCDate("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("order_time not between", value1, value2, "orderTime");
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