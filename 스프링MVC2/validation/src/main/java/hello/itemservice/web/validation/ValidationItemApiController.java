package hello.itemservice.web.validation;

import hello.itemservice.web.validation.from.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {


    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
        log.info("API 호출");

        if(bindingResult.hasErrors()){
            log.info("오류 발생");
            return bindingResult.getAllErrors();
        }

        log.info("성공!!");
        return form;
    }
}
