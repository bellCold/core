package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();

        Member member = new Member(1L, "kim", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findById(1L);

        System.out.println("member: " + member.getName());
        System.out.println("find: " + findMember.getName());

    }
}
