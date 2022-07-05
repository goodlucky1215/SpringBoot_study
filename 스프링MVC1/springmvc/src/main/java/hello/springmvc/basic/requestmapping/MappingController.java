package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class MappingController {

    /*
    *  PathVariable사용
    *  변수명이 같으면 생량이 가능하다.
    * */
    @PostMapping("/mapping/post/{userId}")
    public String mappingPath1(@PathVariable("userId") String data){
      log.info("user Id = {}",data);
      return "ok";
    }

    @GetMapping("/mapping/get/{userId}")
    public String mappingPath2(@PathVariable String userId){
      log.info("user Id = {}",userId);
      return "ok";
    }

    @GetMapping("/mapping/user/{userId}/item/{itemSu}")
    public String mappingPath3(@PathVariable String userId,@PathVariable Long itemSu){
      log.info("user userId = {}",userId);
      log.info("user itemSu = {}",itemSu);
      return "ok";
    }

    @GetMapping(value = "/mapping/params", params = "rule=check")
    public String mappingPath4(){
      return "ok";
    }

    @GetMapping(value = "/mapping/headers", headers = "rule=check")
    public String mappingPath5(){
      return "ok";
    }

    @GetMapping(value = "/mapping/consumes", consumes = "application/json")
    public String mappingPath6(){
      return "ok";
    }


    @GetMapping(value = "/mapping/produces", produces = "text/html")
    public String mappingPath7(){
        return "ok";
    }

}
