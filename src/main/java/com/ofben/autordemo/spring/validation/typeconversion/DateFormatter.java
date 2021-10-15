package com.ofben.autordemo.spring.validation.typeconversion;

import org.springframework.format.Formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * {@link Formatter}
 *
 * @date 2021-10-15
 * @since 1.0.0
 */
public final class DateFormatter implements Formatter<Date> {

    private String pattern;

    public DateFormatter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String print(Date date, Locale locale) {
        if (date == null) {
            return "";
        }
        return getDateFormat(locale).format(date);
    }

    @Override
    public Date parse(String formatted, Locale locale) throws ParseException {
        if (formatted.length() == 0) {
            return null;
        }
        return getDateFormat(locale).parse(formatted);
    }

    private DateFormat getDateFormat(Locale locale) {
        DateFormat dateFormat = new SimpleDateFormat(this.pattern, locale);
        dateFormat.setLenient(false);
        return dateFormat;
    }

    public static void main(String[] args) {
        DateFormatter dateFormatter = new DateFormatter("yyyy-MM-dd ss:mm:ss");
        Locale locale = new Locale("zh");
        String print = dateFormatter.print(new Date(), locale);
        System.out.println(print);
    }
}
