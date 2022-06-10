package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){ //Model을 하면 데이터를 실어서 넘길 수 있다.
        model.addAttribute("data","hello!!!!");
        return "hello";
        //자동으로 .html이 붙어서 화면으로 간다.
        //thymeleaf가 "resources:templates/"+뷰네임+".html"을 매핑해주는 것이다.
    }
}
