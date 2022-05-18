package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    /*
    [주입 방법 1] 필드 주입
    @Autowired MemberService memberService;

    [주입 방법 2] setter주입
    MemberService memberService;
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }

    */

        MemberService memberService;

        //[주입 방법 3] 생성자 주입
        @Autowired
        public  MemberController(MemberService memberService){
            this.memberService = memberService;
        }
}
