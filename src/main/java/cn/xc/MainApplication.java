package cn.xc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

/**
 *  启动类
 * @version V1.0
 * @Author XiongCheng
 * @Date 2018/1/17 15:23.
 */
@SpringBootApplication
@MapperScan("cn.xc.dao")
public class MainApplication extends SpringBootServletInitializer{
    /**
     *
     * @param args
     * @return
     */
    public static void main(String[] args){
        SpringApplication.run(MainApplication.class,args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MainApplication.class);
    }
    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }
}
