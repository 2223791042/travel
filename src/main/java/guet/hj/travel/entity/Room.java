package guet.hj.travel.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Room {
    private Long roomId;

    private String roomType;

    private String roomBedType;

    private String roomBreakfast;

    private String roomArea;

    private BigDecimal roomPrice;

    private String roomHotelName;

    private Long roomHotelId;

    private String roomStatus;

    private String roomRelease;

    private Date roomReleaseTime;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getRoomBedType() {
        return roomBedType;
    }

    public void setRoomBedType(String roomBedType) {
        this.roomBedType = roomBedType == null ? null : roomBedType.trim();
    }

    public String getRoomBreakfast() {
        return roomBreakfast;
    }

    public void setRoomBreakfast(String roomBreakfast) {
        this.roomBreakfast = roomBreakfast == null ? null : roomBreakfast.trim();
    }

    public String getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea == null ? null : roomArea.trim();
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomHotelName() {
        return roomHotelName;
    }

    public void setRoomHotelName(String roomHotelName) {
        this.roomHotelName = roomHotelName == null ? null : roomHotelName.trim();
    }

    public Long getRoomHotelId() {
        return roomHotelId;
    }

    public void setRoomHotelId(Long roomHotelId) {
        this.roomHotelId = roomHotelId;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus == null ? null : roomStatus.trim();
    }

    public String getRoomRelease() {
        return roomRelease;
    }

    public void setRoomRelease(String roomRelease) {
        this.roomRelease = roomRelease == null ? null : roomRelease.trim();
    }

    public Date getRoomReleaseTime() {
        return roomReleaseTime;
    }

    public void setRoomReleaseTime(Date roomReleaseTime) {
        this.roomReleaseTime = roomReleaseTime;
    }
}