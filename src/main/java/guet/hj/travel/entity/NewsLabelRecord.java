package guet.hj.travel.entity;

public class NewsLabelRecord {
    private Long recordId;

    private Long newsId;

    private Integer newsLabelId;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public Integer getNewsLabelId() {
        return newsLabelId;
    }

    public void setNewsLabelId(Integer newsLabelId) {
        this.newsLabelId = newsLabelId;
    }
}