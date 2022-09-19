package cloneProject.server.order;

import cloneProject.server.discount.DiscountPolicy;
import cloneProject.server.discount.FixDiscountPolicy;
import cloneProject.server.member.Member;
import cloneProject.server.member.MemberRepository;
import cloneProject.server.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
