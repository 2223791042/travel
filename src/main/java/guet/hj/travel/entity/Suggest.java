package guet.hj.travel.entity;

import java.util.Date;

public class Suggest {
    private Long suggestId;

    private String title;

    private String username;

    private String telephone;

    private String suggest;

    private String carryFile;

    private Date suggestTime;

    public Long getSuggestId() {
        return suggestId;
    }

    public void setSuggestId(Long suggestId) {
        this.suggestId = suggestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest == null ? null : suggest.trim();
    }

    public String getCarryFile() {
        return carryFile;
    }

    public void setCarryFile(String carryFile) {
        this.carryFile = carryFile == null ? null : carryFile.trim();
    }

    public Date getSuggestTime() {
        return suggestTime;
    }

    public void setSuggestTime(Date suggestTime) {
        this.suggestTime = suggestTime;
    }
}