package hello.springmvc.basic.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
@Slf4j
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/request-body-json-v1")
    public void requestBodyStringV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody={}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("Username={},age={}", helloData.getUsername(), helloData.getAge());

        response.getWriter().write("ok");
    }


    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyStringV2(@RequestBody String messageBody) throws JsonProcessingException {

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("Username={},age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyStringV3(@RequestBody HelloData helloData) { //쿼리파라미터가 @Attribute를 생략하므로 메시지바디는 @RequestBody생략 안됨!!

        log.info("Username={},age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v4")
    public String requestBodyStringV4(HttpEntity<HelloData> messageBody) {
        HelloData helloData = messageBody.getBody();
        log.info("Username={},age={}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }


    @ResponseBody
    @PostMapping("/request-body-json-v5")
    public HelloData requestBodyStringV5(@RequestBody HelloData helloData) {
        log.info("Username={},age={}", helloData.getUsername(), helloData.getAge());

        return helloData;
    }
}
