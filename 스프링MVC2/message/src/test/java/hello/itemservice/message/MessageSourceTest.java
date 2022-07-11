package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    MessageSource ms;

    @Autowired
    public MessageSourceTest(MessageSource messageSource) {
        this.ms = messageSource;
    }

    @Test
    void helloMessage(){
        String result = ms.getMessage("hello",null,null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test
    void notFoundMessageCode(){
        assertThatThrownBy(() -> ms.getMessage("no_code",null,null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void notFoundMessageCodeDefaultMessage(){
        String result = ms.getMessage("no_code",null,"기본 메시지",null);
        assertThat(result).isEqualTo("기본 메시지");
    }

    @Test
    void argumentMessage(){
        String result = ms.getMessage("hello.name",new Object[]{"rabbit"},null);
        assertThat(result).isEqualTo("안녕 rabbit");
    }

    @Test
    void defaultLang(){
        assertThat(ms.getMessage("hello", null,null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null,Locale.KOREA)).isEqualTo("안녕");
    }

    @Test
    void enLang(){
        assertThat(ms.getMessage("hello", null,Locale.ENGLISH)).isEqualTo("hello");
    }
}
