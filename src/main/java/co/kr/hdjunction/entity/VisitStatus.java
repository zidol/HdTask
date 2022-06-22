package co.kr.hdjunction.entity;

public enum VisitStatus {

    VISITING(1, "방문중"), END(2, "종료"), CANCEL(3, "취소");
    private final int value;
    private final String  desc;
    private VisitStatus(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
