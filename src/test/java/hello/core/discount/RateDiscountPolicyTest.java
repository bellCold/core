package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    void vip_o() {
        Member member = new Member(1L, "kim", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x() {
        Member member = new Member(1L, "kim", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, 10000);

        assertThat(discount).isEqualTo(0);
    }
}