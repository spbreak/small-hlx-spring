package cn.hlx.springframework.test.converter;

import cn.hlx.springframework.core.convert.converter.Converter;

/**
 *
 * 
 * 
 * */
public class StringToIntegerConverter implements Converter<String, Integer> {
    
    @Override
    public Integer convert(String source) {
        return Integer.valueOf(source);
    }
}
