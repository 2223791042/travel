package guet.hj.travel.enums;

import lombok.Getter;

@Getter
public enum ViewNoticeEnum {

    SAVE("0", "保存"),

    RELEASE("1", "发布"),
    ;

    private String noticeStatus;

    private String message;

    ViewNoticeEnum(String noticeStatus, String message) {
        this.noticeStatus = noticeStatus;
        this.message = message;
    }
}