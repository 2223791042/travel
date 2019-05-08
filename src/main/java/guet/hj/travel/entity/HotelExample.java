package guet.hj.travel.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryIsNull() {
            addCriterion("hotel_summary is null");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryIsNotNull() {
            addCriterion("hotel_summary is not null");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryEqualTo(String value) {
            addCriterion("hotel_summary =", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryNotEqualTo(String value) {
            addCriterion("hotel_summary <>", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryGreaterThan(String value) {
            addCriterion("hotel_summary >", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_summary >=", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryLessThan(String value) {
            addCriterion("hotel_summary <", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryLessThanOrEqualTo(String value) {
            addCriterion("hotel_summary <=", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryLike(String value) {
            addCriterion("hotel_summary like", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryNotLike(String value) {
            addCriterion("hotel_summary not like", value, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryIn(List<String> values) {
            addCriterion("hotel_summary in", values, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryNotIn(List<String> values) {
            addCriterion("hotel_summary not in", values, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryBetween(String value1, String value2) {
            addCriterion("hotel_summary between", value1, value2, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelSummaryNotBetween(String value1, String value2) {
            addCriterion("hotel_summary not between", value1, value2, "hotelSummary");
            return (Criteria) this;
        }

        public Criteria andHotelIconIsNull() {
            addCriterion("hotel_icon is null");
            return (Criteria) this;
        }

        public Criteria andHotelIconIsNotNull() {
            addCriterion("hotel_icon is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIconEqualTo(String value) {
            addCriterion("hotel_icon =", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconNotEqualTo(String value) {
            addCriterion("hotel_icon <>", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconGreaterThan(String value) {
            addCriterion("hotel_icon >", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_icon >=", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconLessThan(String value) {
            addCriterion("hotel_icon <", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconLessThanOrEqualTo(String value) {
            addCriterion("hotel_icon <=", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconLike(String value) {
            addCriterion("hotel_icon like", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconNotLike(String value) {
            addCriterion("hotel_icon not like", value, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconIn(List<String> values) {
            addCriterion("hotel_icon in", values, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconNotIn(List<String> values) {
            addCriterion("hotel_icon not in", values, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconBetween(String value1, String value2) {
            addCriterion("hotel_icon between", value1, value2, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelIconNotBetween(String value1, String value2) {
            addCriterion("hotel_icon not between", value1, value2, "hotelIcon");
            return (Criteria) this;
        }

        public Criteria andHotelImageIsNull() {
            addCriterion("hotel_image is null");
            return (Criteria) this;
        }

        public Criteria andHotelImageIsNotNull() {
            addCriterion("hotel_image is not null");
            return (Criteria) this;
        }

        public Criteria andHotelImageEqualTo(String value) {
            addCriterion("hotel_image =", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotEqualTo(String value) {
            addCriterion("hotel_image <>", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageGreaterThan(String value) {
            addCriterion("hotel_image >", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_image >=", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLessThan(String value) {
            addCriterion("hotel_image <", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLessThanOrEqualTo(String value) {
            addCriterion("hotel_image <=", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLike(String value) {
            addCriterion("hotel_image like", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotLike(String value) {
            addCriterion("hotel_image not like", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageIn(List<String> values) {
            addCriterion("hotel_image in", values, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotIn(List<String> values) {
            addCriterion("hotel_image not in", values, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageBetween(String value1, String value2) {
            addCriterion("hotel_image between", value1, value2, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotBetween(String value1, String value2) {
            addCriterion("hotel_image not between", value1, value2, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelAddrIsNull() {
            addCriterion("hotel_addr is null");
            return (Criteria) this;
        }

        public Criteria andHotelAddrIsNotNull() {
            addCriterion("hotel_addr is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAddrEqualTo(String value) {
            addCriterion("hotel_addr =", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrNotEqualTo(String value) {
            addCriterion("hotel_addr <>", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrGreaterThan(String value) {
            addCriterion("hotel_addr >", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_addr >=", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrLessThan(String value) {
            addCriterion("hotel_addr <", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrLessThanOrEqualTo(String value) {
            addCriterion("hotel_addr <=", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrLike(String value) {
            addCriterion("hotel_addr like", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrNotLike(String value) {
            addCriterion("hotel_addr not like", value, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrIn(List<String> values) {
            addCriterion("hotel_addr in", values, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrNotIn(List<String> values) {
            addCriterion("hotel_addr not in", values, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrBetween(String value1, String value2) {
            addCriterion("hotel_addr between", value1, value2, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelAddrNotBetween(String value1, String value2) {
            addCriterion("hotel_addr not between", value1, value2, "hotelAddr");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNull() {
            addCriterion("hotel_price is null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIsNotNull() {
            addCriterion("hotel_price is not null");
            return (Criteria) this;
        }

        public Criteria andHotelPriceEqualTo(String value) {
            addCriterion("hotel_price =", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotEqualTo(String value) {
            addCriterion("hotel_price <>", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThan(String value) {
            addCriterion("hotel_price >", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_price >=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThan(String value) {
            addCriterion("hotel_price <", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLessThanOrEqualTo(String value) {
            addCriterion("hotel_price <=", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceLike(String value) {
            addCriterion("hotel_price like", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotLike(String value) {
            addCriterion("hotel_price not like", value, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceIn(List<String> values) {
            addCriterion("hotel_price in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotIn(List<String> values) {
            addCriterion("hotel_price not in", values, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceBetween(String value1, String value2) {
            addCriterion("hotel_price between", value1, value2, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelPriceNotBetween(String value1, String value2) {
            addCriterion("hotel_price not between", value1, value2, "hotelPrice");
            return (Criteria) this;
        }

        public Criteria andHotelScaleIsNull() {
            addCriterion("hotel_scale is null");
            return (Criteria) this;
        }

        public Criteria andHotelScaleIsNotNull() {
            addCriterion("hotel_scale is not null");
            return (Criteria) this;
        }

        public Criteria andHotelScaleEqualTo(String value) {
            addCriterion("hotel_scale =", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleNotEqualTo(String value) {
            addCriterion("hotel_scale <>", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleGreaterThan(String value) {
            addCriterion("hotel_scale >", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_scale >=", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleLessThan(String value) {
            addCriterion("hotel_scale <", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleLessThanOrEqualTo(String value) {
            addCriterion("hotel_scale <=", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleLike(String value) {
            addCriterion("hotel_scale like", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleNotLike(String value) {
            addCriterion("hotel_scale not like", value, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleIn(List<String> values) {
            addCriterion("hotel_scale in", values, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleNotIn(List<String> values) {
            addCriterion("hotel_scale not in", values, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleBetween(String value1, String value2) {
            addCriterion("hotel_scale between", value1, value2, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelScaleNotBetween(String value1, String value2) {
            addCriterion("hotel_scale not between", value1, value2, "hotelScale");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeIsNull() {
            addCriterion("hotel_room_type is null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeIsNotNull() {
            addCriterion("hotel_room_type is not null");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeEqualTo(String value) {
            addCriterion("hotel_room_type =", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotEqualTo(String value) {
            addCriterion("hotel_room_type <>", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeGreaterThan(String value) {
            addCriterion("hotel_room_type >", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_room_type >=", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLessThan(String value) {
            addCriterion("hotel_room_type <", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("hotel_room_type <=", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeLike(String value) {
            addCriterion("hotel_room_type like", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotLike(String value) {
            addCriterion("hotel_room_type not like", value, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeIn(List<String> values) {
            addCriterion("hotel_room_type in", values, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotIn(List<String> values) {
            addCriterion("hotel_room_type not in", values, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeBetween(String value1, String value2) {
            addCriterion("hotel_room_type between", value1, value2, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelRoomTypeNotBetween(String value1, String value2) {
            addCriterion("hotel_room_type not between", value1, value2, "hotelRoomType");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesIsNull() {
            addCriterion("hotel_facilities is null");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesIsNotNull() {
            addCriterion("hotel_facilities is not null");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesEqualTo(String value) {
            addCriterion("hotel_facilities =", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesNotEqualTo(String value) {
            addCriterion("hotel_facilities <>", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesGreaterThan(String value) {
            addCriterion("hotel_facilities >", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_facilities >=", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesLessThan(String value) {
            addCriterion("hotel_facilities <", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesLessThanOrEqualTo(String value) {
            addCriterion("hotel_facilities <=", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesLike(String value) {
            addCriterion("hotel_facilities like", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesNotLike(String value) {
            addCriterion("hotel_facilities not like", value, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesIn(List<String> values) {
            addCriterion("hotel_facilities in", values, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesNotIn(List<String> values) {
            addCriterion("hotel_facilities not in", values, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesBetween(String value1, String value2) {
            addCriterion("hotel_facilities between", value1, value2, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelFacilitiesNotBetween(String value1, String value2) {
            addCriterion("hotel_facilities not between", value1, value2, "hotelFacilities");
            return (Criteria) this;
        }

        public Criteria andHotelDescIsNull() {
            addCriterion("hotel_desc is null");
            return (Criteria) this;
        }

        public Criteria andHotelDescIsNotNull() {
            addCriterion("hotel_desc is not null");
            return (Criteria) this;
        }

        public Criteria andHotelDescEqualTo(String value) {
            addCriterion("hotel_desc =", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescNotEqualTo(String value) {
            addCriterion("hotel_desc <>", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescGreaterThan(String value) {
            addCriterion("hotel_desc >", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_desc >=", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescLessThan(String value) {
            addCriterion("hotel_desc <", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescLessThanOrEqualTo(String value) {
            addCriterion("hotel_desc <=", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescLike(String value) {
            addCriterion("hotel_desc like", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescNotLike(String value) {
            addCriterion("hotel_desc not like", value, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescIn(List<String> values) {
            addCriterion("hotel_desc in", values, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescNotIn(List<String> values) {
            addCriterion("hotel_desc not in", values, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescBetween(String value1, String value2) {
            addCriterion("hotel_desc between", value1, value2, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelDescNotBetween(String value1, String value2) {
            addCriterion("hotel_desc not between", value1, value2, "hotelDesc");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdIsNull() {
            addCriterion("hotel_type_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdIsNotNull() {
            addCriterion("hotel_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdEqualTo(Integer value) {
            addCriterion("hotel_type_id =", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdNotEqualTo(Integer value) {
            addCriterion("hotel_type_id <>", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdGreaterThan(Integer value) {
            addCriterion("hotel_type_id >", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_type_id >=", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdLessThan(Integer value) {
            addCriterion("hotel_type_id <", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_type_id <=", value, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdIn(List<Integer> values) {
            addCriterion("hotel_type_id in", values, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdNotIn(List<Integer> values) {
            addCriterion("hotel_type_id not in", values, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_type_id between", value1, value2, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_type_id not between", value1, value2, "hotelTypeId");
            return (Criteria) this;
        }

        public Criteria andHotelOrderIsNull() {
            addCriterion("hotel_order is null");
            return (Criteria) this;
        }

        public Criteria andHotelOrderIsNotNull() {
            addCriterion("hotel_order is not null");
            return (Criteria) this;
        }

        public Criteria andHotelOrderEqualTo(Integer value) {
            addCriterion("hotel_order =", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderNotEqualTo(Integer value) {
            addCriterion("hotel_order <>", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderGreaterThan(Integer value) {
            addCriterion("hotel_order >", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_order >=", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderLessThan(Integer value) {
            addCriterion("hotel_order <", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_order <=", value, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderIn(List<Integer> values) {
            addCriterion("hotel_order in", values, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderNotIn(List<Integer> values) {
            addCriterion("hotel_order not in", values, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderBetween(Integer value1, Integer value2) {
            addCriterion("hotel_order between", value1, value2, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_order not between", value1, value2, "hotelOrder");
            return (Criteria) this;
        }

        public Criteria andHotelStatusIsNull() {
            addCriterion("hotel_status is null");
            return (Criteria) this;
        }

        public Criteria andHotelStatusIsNotNull() {
            addCriterion("hotel_status is not null");
            return (Criteria) this;
        }

        public Criteria andHotelStatusEqualTo(String value) {
            addCriterion("hotel_status =", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusNotEqualTo(String value) {
            addCriterion("hotel_status <>", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusGreaterThan(String value) {
            addCriterion("hotel_status >", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_status >=", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusLessThan(String value) {
            addCriterion("hotel_status <", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusLessThanOrEqualTo(String value) {
            addCriterion("hotel_status <=", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusLike(String value) {
            addCriterion("hotel_status like", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusNotLike(String value) {
            addCriterion("hotel_status not like", value, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusIn(List<String> values) {
            addCriterion("hotel_status in", values, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusNotIn(List<String> values) {
            addCriterion("hotel_status not in", values, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusBetween(String value1, String value2) {
            addCriterion("hotel_status between", value1, value2, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelStatusNotBetween(String value1, String value2) {
            addCriterion("hotel_status not between", value1, value2, "hotelStatus");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseIsNull() {
            addCriterion("hotel_release is null");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseIsNotNull() {
            addCriterion("hotel_release is not null");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseEqualTo(String value) {
            addCriterion("hotel_release =", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseNotEqualTo(String value) {
            addCriterion("hotel_release <>", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseGreaterThan(String value) {
            addCriterion("hotel_release >", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_release >=", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseLessThan(String value) {
            addCriterion("hotel_release <", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseLessThanOrEqualTo(String value) {
            addCriterion("hotel_release <=", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseLike(String value) {
            addCriterion("hotel_release like", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseNotLike(String value) {
            addCriterion("hotel_release not like", value, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseIn(List<String> values) {
            addCriterion("hotel_release in", values, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseNotIn(List<String> values) {
            addCriterion("hotel_release not in", values, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseBetween(String value1, String value2) {
            addCriterion("hotel_release between", value1, value2, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseNotBetween(String value1, String value2) {
            addCriterion("hotel_release not between", value1, value2, "hotelRelease");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeIsNull() {
            addCriterion("hotel_release_time is null");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeIsNotNull() {
            addCriterion("hotel_release_time is not null");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeEqualTo(Date value) {
            addCriterionForJDBCDate("hotel_release_time =", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("hotel_release_time <>", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("hotel_release_time >", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hotel_release_time >=", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeLessThan(Date value) {
            addCriterionForJDBCDate("hotel_release_time <", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("hotel_release_time <=", value, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeIn(List<Date> values) {
            addCriterionForJDBCDate("hotel_release_time in", values, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("hotel_release_time not in", values, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hotel_release_time between", value1, value2, "hotelReleaseTime");
            return (Criteria) this;
        }

        public Criteria andHotelReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("hotel_release_time not between", value1, value2, "hotelReleaseTime");
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