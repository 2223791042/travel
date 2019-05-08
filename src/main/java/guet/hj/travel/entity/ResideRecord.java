package guet.hj.travel.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ResideRecord {
    private Long resideId;

    private Long consumerId;

    private Long roomId;

    private Date inTime;

    private Date outTime;

    private Integer resideDays;

    private BigDecimal resideCost;

    private Date orderTime;

    public Long getResideId() {
        return resideId;
    }

    public void setResideId(Long resideId) {
        this.resideId = resideId;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public Integer getResideDays() {
        return resideDays;
    }

    public void setResideDays(Integer resideDays) {
        this.resideDays = resideDays;
    }

    public BigDecimal getResideCost() {
        return resideCost;
    }

    public void setResideCost(BigDecimal resideCost) {
        this.resideCost = resideCost;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}