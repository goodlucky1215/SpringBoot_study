package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //1. 정적 페이지
    //html불러서 직접 들어가는 것 => http://localhost:8080/hello-static.html

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello jiny");
        return "hello";
    }

    //2. mvc형태 페이지
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //3. api(feat.@ResponseBody)
    @GetMapping("hello-api")
    @ResponseBody
    public String helloMvc(@RequestParam(value = "name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return "hello-template";
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
