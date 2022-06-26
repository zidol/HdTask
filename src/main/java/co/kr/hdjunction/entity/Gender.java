package co.kr.hdjunction.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Locale;

public enum Gender {

    M("남"), F("여");
    private final String desc;
    Gender(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

//    @JsonCreator
//    public static Gender from(String s) {
//        return Gender.valueOf(s.toUpperCase());
//    }
}
