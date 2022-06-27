package co.kr.hdjunction.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VisitStatusTest {

    @Test
    void visitStatusBasicTest() {

        assertThat(VisitStatus.VISITING.getDesc()).isEqualTo("방문중");
        assertThat(VisitStatus.VISITING.getValue()).isEqualTo(1);

        assertThat(VisitStatus.END.getDesc()).isEqualTo("종료");
        assertThat(VisitStatus.END.getValue()).isEqualTo(2);

        assertThat(VisitStatus.CANCEL.getDesc()).isEqualTo("취소");
        assertThat(VisitStatus.CANCEL.getValue()).isEqualTo(3);
    }

}