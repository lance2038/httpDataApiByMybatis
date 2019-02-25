package com.lance.common.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author lance
 * @version v0.0.1
 * @describe FastJson转换器
 * @since 2018/8/29
 **/
@Configuration
public class FastjsonConfiguration extends WebMvcConfigurerAdapter
{
    @Bean
    public FastJsonConfig fastJsonConfig()
    {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        SerializerFeature writeMapNullValue = SerializerFeature.WriteMapNullValue;
        SerializerFeature writeNullStringAsEmpty = SerializerFeature.WriteNullStringAsEmpty;
        SerializerFeature writeNullNumberAsZero = SerializerFeature.WriteNullNumberAsZero;
        SerializerFeature writeNullListAsEmpty = SerializerFeature.WriteNullListAsEmpty;
        fastJsonConfig.setSerializerFeatures(writeMapNullValue, writeNullStringAsEmpty, writeNullNumberAsZero, writeNullListAsEmpty);
        return fastJsonConfig;
    }

    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters(@Qualifier("fastJsonConfig") FastJsonConfig fastJsonConfig)
    {
        FastJsonHttpMessageConverter4 fastConverter = new FastJsonHttpMessageConverter4();
        fastConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }
}
