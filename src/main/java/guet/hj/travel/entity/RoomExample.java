package guet.hj.travel.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomExample() {
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

        public Criteria andRoomTypeIsNull() {
            addCriterion("room_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("room_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(String value) {
            addCriterion("room_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(String value) {
            addCriterion("room_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(String value) {
            addCriterion("room_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("room_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(String value) {
            addCriterion("room_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("room_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLike(String value) {
            addCriterion("room_type like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotLike(String value) {
            addCriterion("room_type not like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<String> values) {
            addCriterion("room_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<String> values) {
            addCriterion("room_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(String value1, String value2) {
            addCriterion("room_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(String value1, String value2) {
            addCriterion("room_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIsNull() {
            addCriterion("room_bed_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIsNotNull() {
            addCriterion("room_bed_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeEqualTo(String value) {
            addCriterion("room_bed_type =", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotEqualTo(String value) {
            addCriterion("room_bed_type <>", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeGreaterThan(String value) {
            addCriterion("room_bed_type >", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("room_bed_type >=", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeLessThan(String value) {
            addCriterion("room_bed_type <", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeLessThanOrEqualTo(String value) {
            addCriterion("room_bed_type <=", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeLike(String value) {
            addCriterion("room_bed_type like", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotLike(String value) {
            addCriterion("room_bed_type not like", value, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeIn(List<String> values) {
            addCriterion("room_bed_type in", values, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotIn(List<String> values) {
            addCriterion("room_bed_type not in", values, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeBetween(String value1, String value2) {
            addCriterion("room_bed_type between", value1, value2, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBedTypeNotBetween(String value1, String value2) {
            addCriterion("room_bed_type not between", value1, value2, "roomBedType");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastIsNull() {
            addCriterion("room_breakfast is null");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastIsNotNull() {
            addCriterion("room_breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastEqualTo(String value) {
            addCriterion("room_breakfast =", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastNotEqualTo(String value) {
            addCriterion("room_breakfast <>", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastGreaterThan(String value) {
            addCriterion("room_breakfast >", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastGreaterThanOrEqualTo(String value) {
            addCriterion("room_breakfast >=", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastLessThan(String value) {
            addCriterion("room_breakfast <", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastLessThanOrEqualTo(String value) {
            addCriterion("room_breakfast <=", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastLike(String value) {
            addCriterion("room_breakfast like", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastNotLike(String value) {
            addCriterion("room_breakfast not like", value, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastIn(List<String> values) {
            addCriterion("room_breakfast in", values, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastNotIn(List<String> values) {
            addCriterion("room_breakfast not in", values, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastBetween(String value1, String value2) {
            addCriterion("room_breakfast between", value1, value2, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomBreakfastNotBetween(String value1, String value2) {
            addCriterion("room_breakfast not between", value1, value2, "roomBreakfast");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIsNull() {
            addCriterion("room_area is null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIsNotNull() {
            addCriterion("room_area is not null");
            return (Criteria) this;
        }

        public Criteria andRoomAreaEqualTo(String value) {
            addCriterion("room_area =", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotEqualTo(String value) {
            addCriterion("room_area <>", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThan(String value) {
            addCriterion("room_area >", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaGreaterThanOrEqualTo(String value) {
            addCriterion("room_area >=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThan(String value) {
            addCriterion("room_area <", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLessThanOrEqualTo(String value) {
            addCriterion("room_area <=", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaLike(String value) {
            addCriterion("room_area like", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotLike(String value) {
            addCriterion("room_area not like", value, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaIn(List<String> values) {
            addCriterion("room_area in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotIn(List<String> values) {
            addCriterion("room_area not in", values, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaBetween(String value1, String value2) {
            addCriterion("room_area between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomAreaNotBetween(String value1, String value2) {
            addCriterion("room_area not between", value1, value2, "roomArea");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIsNull() {
            addCriterion("room_price is null");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIsNotNull() {
            addCriterion("room_price is not null");
            return (Criteria) this;
        }

        public Criteria andRoomPriceEqualTo(BigDecimal value) {
            addCriterion("room_price =", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotEqualTo(BigDecimal value) {
            addCriterion("room_price <>", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceGreaterThan(BigDecimal value) {
            addCriterion("room_price >", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("room_price >=", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceLessThan(BigDecimal value) {
            addCriterion("room_price <", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("room_price <=", value, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceIn(List<BigDecimal> values) {
            addCriterion("room_price in", values, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotIn(List<BigDecimal> values) {
            addCriterion("room_price not in", values, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("room_price between", value1, value2, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("room_price not between", value1, value2, "roomPrice");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameIsNull() {
            addCriterion("room_hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameIsNotNull() {
            addCriterion("room_hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameEqualTo(String value) {
            addCriterion("room_hotel_name =", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameNotEqualTo(String value) {
            addCriterion("room_hotel_name <>", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameGreaterThan(String value) {
            addCriterion("room_hotel_name >", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_hotel_name >=", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameLessThan(String value) {
            addCriterion("room_hotel_name <", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameLessThanOrEqualTo(String value) {
            addCriterion("room_hotel_name <=", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameLike(String value) {
            addCriterion("room_hotel_name like", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameNotLike(String value) {
            addCriterion("room_hotel_name not like", value, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameIn(List<String> values) {
            addCriterion("room_hotel_name in", values, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameNotIn(List<String> values) {
            addCriterion("room_hotel_name not in", values, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameBetween(String value1, String value2) {
            addCriterion("room_hotel_name between", value1, value2, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelNameNotBetween(String value1, String value2) {
            addCriterion("room_hotel_name not between", value1, value2, "roomHotelName");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdIsNull() {
            addCriterion("room_hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdIsNotNull() {
            addCriterion("room_hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdEqualTo(Long value) {
            addCriterion("room_hotel_id =", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdNotEqualTo(Long value) {
            addCriterion("room_hotel_id <>", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdGreaterThan(Long value) {
            addCriterion("room_hotel_id >", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_hotel_id >=", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdLessThan(Long value) {
            addCriterion("room_hotel_id <", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("room_hotel_id <=", value, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdIn(List<Long> values) {
            addCriterion("room_hotel_id in", values, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdNotIn(List<Long> values) {
            addCriterion("room_hotel_id not in", values, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdBetween(Long value1, Long value2) {
            addCriterion("room_hotel_id between", value1, value2, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("room_hotel_id not between", value1, value2, "roomHotelId");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNull() {
            addCriterion("room_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("room_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(String value) {
            addCriterion("room_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(String value) {
            addCriterion("room_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(String value) {
            addCriterion("room_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(String value) {
            addCriterion("room_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(String value) {
            addCriterion("room_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(String value) {
            addCriterion("room_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLike(String value) {
            addCriterion("room_status like", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotLike(String value) {
            addCriterion("room_status not like", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<String> values) {
            addCriterion("room_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<String> values) {
            addCriterion("room_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(String value1, String value2) {
            addCriterion("room_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(String value1, String value2) {
            addCriterion("room_status not between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseIsNull() {
            addCriterion("room_release is null");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseIsNotNull() {
            addCriterion("room_release is not null");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseEqualTo(String value) {
            addCriterion("room_release =", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseNotEqualTo(String value) {
            addCriterion("room_release <>", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseGreaterThan(String value) {
            addCriterion("room_release >", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseGreaterThanOrEqualTo(String value) {
            addCriterion("room_release >=", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseLessThan(String value) {
            addCriterion("room_release <", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseLessThanOrEqualTo(String value) {
            addCriterion("room_release <=", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseLike(String value) {
            addCriterion("room_release like", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseNotLike(String value) {
            addCriterion("room_release not like", value, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseIn(List<String> values) {
            addCriterion("room_release in", values, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseNotIn(List<String> values) {
            addCriterion("room_release not in", values, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseBetween(String value1, String value2) {
            addCriterion("room_release between", value1, value2, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseNotBetween(String value1, String value2) {
            addCriterion("room_release not between", value1, value2, "roomRelease");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeIsNull() {
            addCriterion("room_release_time is null");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeIsNotNull() {
            addCriterion("room_release_time is not null");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeEqualTo(Date value) {
            addCriterionForJDBCDate("room_release_time =", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("room_release_time <>", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("room_release_time >", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("room_release_time >=", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeLessThan(Date value) {
            addCriterionForJDBCDate("room_release_time <", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("room_release_time <=", value, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeIn(List<Date> values) {
            addCriterionForJDBCDate("room_release_time in", values, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("room_release_time not in", values, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("room_release_time between", value1, value2, "roomReleaseTime");
            return (Criteria) this;
        }

        public Criteria andRoomReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("room_release_time not between", value1, value2, "roomReleaseTime");
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