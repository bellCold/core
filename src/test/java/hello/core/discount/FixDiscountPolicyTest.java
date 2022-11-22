package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FixDiscountPolicyTest {

    FixDiscountPolicy fixDiscountPolicy = new FixDiscountPolicy();

    @Test
    @DisplayName("VIP는 고정 1000원 할인")
    void vip_O() {
        //given
        Member member = new Member(1L, "userA", Grade.VIP);

        //when
        int discountPrice = fixDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 할인X")
    void vip_X() {
        //given
        Member member = new Member(1L, "userB", Grade.BASIC);

        //when
        int discountPrice = fixDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discountPrice).isEqualTo(0);
    }

}
