package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {
    @Test
    void conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());

        Integer result1 = conversionService.convert("10", Integer.class);
        String result2 = conversionService.convert(10, String.class);
        Assertions.assertThat(result1).isEqualTo(10);
        Assertions.assertThat(result2).isEqualTo("10");
    }
}
