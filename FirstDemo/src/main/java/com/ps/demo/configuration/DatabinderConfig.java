package com.ps.demo.configuration;

import com.ps.demo.service.Message;
import com.ps.demo.service.SenderType;
import com.ps.demo.service.SenderTypeConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
@Configuration
public class DatabinderConfig {
    @Bean
    public RequestMappingHandlerAdapter webBindingInitializer() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.setWebBindingInitializer(new WebBindingInitializer(){

            @Override
            public void initBinder(WebDataBinder binder) {
                binder.registerCustomEditor(Message.class, new SenderTypeConverter());
            }
        });
        return adapter;
    }
}
