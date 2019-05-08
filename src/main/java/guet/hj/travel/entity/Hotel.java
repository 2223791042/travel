package guet.hj.travel.entity;

import java.util.Date;

public class Hotel {
    private Long hotelId;

    private String hotelName;

    private String hotelSummary;

    private String hotelIcon;

    private String hotelImage;

    private String hotelAddr;

    private String hotelPrice;

    private String hotelScale;

    private String hotelRoomType;

    private String hotelFacilities;

    private String hotelDesc;

    private Integer hotelTypeId;

    private Integer hotelOrder;

    private String hotelStatus;

    private String hotelRelease;

    private Date hotelReleaseTime;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelSummary() {
        return hotelSummary;
    }

    public void setHotelSummary(String hotelSummary) {
        this.hotelSummary = hotelSummary == null ? null : hotelSummary.trim();
    }

    public String getHotelIcon() {
        return hotelIcon;
    }

    public void setHotelIcon(String hotelIcon) {
        this.hotelIcon = hotelIcon == null ? null : hotelIcon.trim();
    }

    public String getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage == null ? null : hotelImage.trim();
    }

    public String getHotelAddr() {
        return hotelAddr;
    }

    public void setHotelAddr(String hotelAddr) {
        this.hotelAddr = hotelAddr == null ? null : hotelAddr.trim();
    }

    public String getHotelPrice() {
        return hotelPrice;
    }

    public void setHotelPrice(String hotelPrice) {
        this.hotelPrice = hotelPrice == null ? null : hotelPrice.trim();
    }

    public String getHotelScale() {
        return hotelScale;
    }

    public void setHotelScale(String hotelScale) {
        this.hotelScale = hotelScale == null ? null : hotelScale.trim();
    }

    public String getHotelRoomType() {
        return hotelRoomType;
    }

    public void setHotelRoomType(String hotelRoomType) {
        this.hotelRoomType = hotelRoomType == null ? null : hotelRoomType.trim();
    }

    public String getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(String hotelFacilities) {
        this.hotelFacilities = hotelFacilities == null ? null : hotelFacilities.trim();
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc == null ? null : hotelDesc.trim();
    }

    public Integer getHotelTypeId() {
        return hotelTypeId;
    }

    public void setHotelTypeId(Integer hotelTypeId) {
        this.hotelTypeId = hotelTypeId;
    }

    public Integer getHotelOrder() {
        return hotelOrder;
    }

    public void setHotelOrder(Integer hotelOrder) {
        this.hotelOrder = hotelOrder;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus == null ? null : hotelStatus.trim();
    }

    public String getHotelRelease() {
        return hotelRelease;
    }

    public void setHotelRelease(String hotelRelease) {
        this.hotelRelease = hotelRelease == null ? null : hotelRelease.trim();
    }

    public Date getHotelReleaseTime() {
        return hotelReleaseTime;
    }

    public void setHotelReleaseTime(Date hotelReleaseTime) {
        this.hotelReleaseTime = hotelReleaseTime;
    }
}