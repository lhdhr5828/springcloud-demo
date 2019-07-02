package com.lee.boot.jwt.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author li.heng
 * @Date 2019/7/2 16
 * @Description: 配置使用阿里的fastjson作为json转换器，即使用RestController和ResponseBody注解的时候
 * 会使用fastjson
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter fastJson = new FastJsonHttpMessageConverter();
        // fastjson配置
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();

//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        ArrayList<MediaType> mediaTypes = new ArrayList<>();
        // 设置返回的页面的contentType，
        // 因为如果不设置的话，页面的content-type为text/html，json数据会乱码
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJson.setSupportedMediaTypes(mediaTypes);
        HttpMessageConverter<?> converter = fastJson;
        converters.add(converter);

    }
}
