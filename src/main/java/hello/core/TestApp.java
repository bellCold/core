package hello.core;

import hello.core.member.*;

public class TestApp {

    public static void main(String[] args) {
        Member member = new Member(1L, "Kim", Grade.VIP);

        MemberRepository memberRepository = new MemoryMemberRepository();

        MemberService memberService = new MemberServiceImpl(memberRepository);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("findMember info = " + findMember.getGrade() + ":" + findMember.getName());


    }
}
