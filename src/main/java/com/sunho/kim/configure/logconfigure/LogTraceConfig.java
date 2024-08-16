package com.sunho.kim.configure.logconfigure;

import com.sunho.kim.trace.logtrace.FieldLogTrace;
import com.sunho.kim.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        //싱글톤으로 등록이 된다.
        return new FieldLogTrace();
    }
}
