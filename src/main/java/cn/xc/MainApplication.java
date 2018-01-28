package cn.xc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
 * @version V1.0
 * @Description: 启动类
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
}
