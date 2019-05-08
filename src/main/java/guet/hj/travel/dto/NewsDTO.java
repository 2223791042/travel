package guet.hj.travel.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import guet.hj.travel.entity.NewsLabel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class NewsDTO {
    private Long newsId;

    private String newsTitle;

    private String newsBrief;

    private String newsImage;

    private String newsContent;

    private String newsKey;

    private Integer newsLabelId;

    private String newsAuthor;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date newsTime;

    private String newsStatus;

    private NewsLabel newsLabel;
}
