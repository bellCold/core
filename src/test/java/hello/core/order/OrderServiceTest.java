package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrderTest() {
        Member member = new Member(1L, "kim", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "kimchi", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
