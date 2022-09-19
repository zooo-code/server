package cloneProject.server;

import cloneProject.server.member.Grade;
import cloneProject.server.member.Member;
import cloneProject.server.member.MemberService;
import cloneProject.server.member.MemberServiceImpl;
import cloneProject.server.order.Order;
import cloneProject.server.order.OrderService;
import cloneProject.server.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
