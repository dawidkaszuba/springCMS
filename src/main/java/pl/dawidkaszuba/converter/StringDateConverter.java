package pl.dawidkaszuba.converter;


import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class StringDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String date) {
        return LocalDate.parse(date);
    }
}
