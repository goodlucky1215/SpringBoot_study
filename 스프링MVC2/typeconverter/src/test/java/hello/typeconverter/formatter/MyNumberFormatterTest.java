package hello.typeconverter.formatter;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Locale;


class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    void parse() throws ParseException {
        Number result = formatter.parse("1,0000", Locale.KOREA);
        assertThat(result).isEqualTo(10000L);
    }

    @Test
    void print(){
        String result = formatter.print(1000,Locale.KOREA);
        assertThat(result).isEqualTo("1,000");
    }
}