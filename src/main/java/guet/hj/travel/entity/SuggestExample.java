package guet.hj.travel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SuggestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuggestExample() {
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

        public Criteria andSuggestIdIsNull() {
            addCriterion("suggest_id is null");
            return (Criteria) this;
        }

        public Criteria andSuggestIdIsNotNull() {
            addCriterion("suggest_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestIdEqualTo(Long value) {
            addCriterion("suggest_id =", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdNotEqualTo(Long value) {
            addCriterion("suggest_id <>", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdGreaterThan(Long value) {
            addCriterion("suggest_id >", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdGreaterThanOrEqualTo(Long value) {
            addCriterion("suggest_id >=", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdLessThan(Long value) {
            addCriterion("suggest_id <", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdLessThanOrEqualTo(Long value) {
            addCriterion("suggest_id <=", value, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdIn(List<Long> values) {
            addCriterion("suggest_id in", values, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdNotIn(List<Long> values) {
            addCriterion("suggest_id not in", values, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdBetween(Long value1, Long value2) {
            addCriterion("suggest_id between", value1, value2, "suggestId");
            return (Criteria) this;
        }

        public Criteria andSuggestIdNotBetween(Long value1, Long value2) {
            addCriterion("suggest_id not between", value1, value2, "suggestId");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andSuggestIsNull() {
            addCriterion("suggest is null");
            return (Criteria) this;
        }

        public Criteria andSuggestIsNotNull() {
            addCriterion("suggest is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestEqualTo(String value) {
            addCriterion("suggest =", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotEqualTo(String value) {
            addCriterion("suggest <>", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThan(String value) {
            addCriterion("suggest >", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestGreaterThanOrEqualTo(String value) {
            addCriterion("suggest >=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThan(String value) {
            addCriterion("suggest <", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLessThanOrEqualTo(String value) {
            addCriterion("suggest <=", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestLike(String value) {
            addCriterion("suggest like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotLike(String value) {
            addCriterion("suggest not like", value, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestIn(List<String> values) {
            addCriterion("suggest in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotIn(List<String> values) {
            addCriterion("suggest not in", values, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestBetween(String value1, String value2) {
            addCriterion("suggest between", value1, value2, "suggest");
            return (Criteria) this;
        }

        public Criteria andSuggestNotBetween(String value1, String value2) {
            addCriterion("suggest not between", value1, value2, "suggest");
            return (Criteria) this;
        }

        public Criteria andCarryFileIsNull() {
            addCriterion("carry_file is null");
            return (Criteria) this;
        }

        public Criteria andCarryFileIsNotNull() {
            addCriterion("carry_file is not null");
            return (Criteria) this;
        }

        public Criteria andCarryFileEqualTo(String value) {
            addCriterion("carry_file =", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileNotEqualTo(String value) {
            addCriterion("carry_file <>", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileGreaterThan(String value) {
            addCriterion("carry_file >", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileGreaterThanOrEqualTo(String value) {
            addCriterion("carry_file >=", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileLessThan(String value) {
            addCriterion("carry_file <", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileLessThanOrEqualTo(String value) {
            addCriterion("carry_file <=", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileLike(String value) {
            addCriterion("carry_file like", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileNotLike(String value) {
            addCriterion("carry_file not like", value, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileIn(List<String> values) {
            addCriterion("carry_file in", values, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileNotIn(List<String> values) {
            addCriterion("carry_file not in", values, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileBetween(String value1, String value2) {
            addCriterion("carry_file between", value1, value2, "carryFile");
            return (Criteria) this;
        }

        public Criteria andCarryFileNotBetween(String value1, String value2) {
            addCriterion("carry_file not between", value1, value2, "carryFile");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIsNull() {
            addCriterion("suggest_time is null");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIsNotNull() {
            addCriterion("suggest_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeEqualTo(Date value) {
            addCriterionForJDBCDate("suggest_time =", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("suggest_time <>", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("suggest_time >", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("suggest_time >=", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeLessThan(Date value) {
            addCriterionForJDBCDate("suggest_time <", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("suggest_time <=", value, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeIn(List<Date> values) {
            addCriterionForJDBCDate("suggest_time in", values, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("suggest_time not in", values, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("suggest_time between", value1, value2, "suggestTime");
            return (Criteria) this;
        }

        public Criteria andSuggestTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("suggest_time not between", value1, value2, "suggestTime");
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