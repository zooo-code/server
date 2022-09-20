package cloneProject.server;

import cloneProject.server.member.Grade;
import cloneProject.server.member.Member;
import cloneProject.server.member.MemberService;
import cloneProject.server.member.MemberServiceImpl;
import cloneProject.server.order.Order;
import cloneProject.server.order.OrderService;
import cloneProject.server.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService =
                applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",
                OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
