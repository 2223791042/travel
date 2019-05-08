package guet.hj.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsLabel {
    private Integer labelId;

    private String labelName;

    private String labelAuthor;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date labelTime;

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelAuthor() {
        return labelAuthor;
    }

    public void setLabelAuthor(String labelAuthor) {
        this.labelAuthor = labelAuthor == null ? null : labelAuthor.trim();
    }

    public Date getLabelTime() {
        return labelTime;
    }

    public void setLabelTime(Date labelTime) {
        this.labelTime = labelTime;
    }
}