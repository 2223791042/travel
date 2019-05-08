package guet.hj.travel.enums;

import lombok.Getter;

@Getter
public enum NewsEnum {

    SAVE("0", "保存"),

    RELEASE("1", "发布"),
    ;

    private String newsStatus;

    private String message;

    NewsEnum(String newsStatus, String message) {
        this.newsStatus = newsStatus;
        this.message = message;
    }
}