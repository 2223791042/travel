package guet.hj.travel.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class News {
    private Long newsId;

    private String newsTitle;

    private String newsImage;

    private String newsBrief;

    private String newsContent;

    private String newsKey;

    private Integer newsLabelId;

    private String newsAuthor;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date newsTime;

    private String newsStatus;

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage == null ? null : newsImage.trim();
    }

    public String getNewsBrief() {
        return newsBrief;
    }

    public void setNewsBrief(String newsBrief) {
        this.newsBrief = newsBrief == null ? null : newsBrief.trim();
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    public String getNewsKey() {
        return newsKey;
    }

    public void setNewsKey(String newsKey) {
        this.newsKey = newsKey == null ? null : newsKey.trim();
    }

    public Integer getNewsLabelId() {
        return newsLabelId;
    }

    public void setNewsLabelId(Integer newsLabelId) {
        this.newsLabelId = newsLabelId;
    }

    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor == null ? null : newsAuthor.trim();
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(String newsStatus) {
        this.newsStatus = newsStatus == null ? null : newsStatus.trim();
    }
}