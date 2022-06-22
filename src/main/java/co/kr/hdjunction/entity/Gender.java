package co.kr.hdjunction.entity;

public enum Gender {

    M("남"), F("여");
    private final String desc;
    Gender(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
}
