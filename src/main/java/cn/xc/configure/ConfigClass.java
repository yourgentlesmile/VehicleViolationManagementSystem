package cn.xc.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 导入applicationcontext.xml配置文件
 * @Author XiongCheng
 * @Date 2018/1/17 19:13.
 * @version V1.0
 */
@Configuration
@ImportResource(locations={"classpath:ApplicationContext.xml"})
public class ConfigClass extends WebMvcConfigurerAdapter{
}
