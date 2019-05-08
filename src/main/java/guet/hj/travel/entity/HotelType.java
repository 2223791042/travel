package guet.hj.travel.entity;

import java.util.Date;

public class HotelType {
    private Integer typeId;

    private String typeName;

    private String typeCreator;

    private Date typeCreateTime;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTypeCreator() {
        return typeCreator;
    }

    public void setTypeCreator(String typeCreator) {
        this.typeCreator = typeCreator == null ? null : typeCreator.trim();
    }

    public Date getTypeCreateTime() {
        return typeCreateTime;
    }

    public void setTypeCreateTime(Date typeCreateTime) {
        this.typeCreateTime = typeCreateTime;
    }
}