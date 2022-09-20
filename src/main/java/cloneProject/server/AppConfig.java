package cloneProject.server;

import cloneProject.server.discount.DiscountPolicy;
import cloneProject.server.discount.FixDiscountPolicy;
import cloneProject.server.member.MemberService;
import cloneProject.server.member.MemberServiceImpl;
import cloneProject.server.member.MemoryMemberRepository;
import cloneProject.server.order.OrderService;
import cloneProject.server.order.OrderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
