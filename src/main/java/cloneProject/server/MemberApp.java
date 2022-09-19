package cloneProject.server;

import cloneProject.server.member.Grade;
import cloneProject.server.member.Member;
import cloneProject.server.member.MemberService;
import cloneProject.server.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args){
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);


    }
}
