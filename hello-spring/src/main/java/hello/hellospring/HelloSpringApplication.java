package hello.hellospring;

import hello.hellospring.domain.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HelloSpringApplication {

    public static void main(String[] args) {
        Map<Long, String> store = new HashMap<>();
        store.put(1L,"a");
        store.put(1L,"a");
        System.out.println(store.get(1L));
        //SpringApplication.run(HelloSpringApplication.class, args);
    }

}
