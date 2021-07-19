package com.example;

import com.jackrain.nea.config.DubboConfig;
import com.jackrain.nea.config.PropertiesConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author: 肖新苗
 * @since: 2020/5/20
 * create at : 2020/5/20 13:27
 */
@SpringBootApplication
@Import({ DubboConfig.class})
public class DemoShellApplication extends SpringBootServletInitializer {
    static {
        System.setProperty("dubbo.application.logger","slf4j");
    }

    public static  void main(String[] args){
        System.setProperty("env","dev");
        System.setProperty("spring.devtools.restart.enable","false");
        System.setProperty("dubbo.application.name","Demo-Shell");


        ApplicationContext context = SpringApplication.run(applicationClass,args);



        System.out.println(context.getBean(PropertiesConf.class).getProperty("spring.datasource.url"));
        System.out.println("Start SpringBoot Success ContextId=" + context.getId());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }



    private static Class<DemoShellApplication> applicationClass = DemoShellApplication.class;
}