package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = applicationContext.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = applicationContext.getBean("statefulService", StatefulService.class);
        int userA = statefulService1.order("userA", 10000);
        int userB = statefulService2.order("userB", 20000);
//        System.out.println("statefulService1.getPrice() = " + statefulService1.getPrice());

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    @Configuration
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}