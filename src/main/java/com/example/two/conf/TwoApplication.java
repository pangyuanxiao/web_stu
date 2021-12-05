package com.example.two.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


/*
    ComponentScan只会扫描他所在目录的子包
    他是支持扫多包的
    @ComponentScan({"com.example.two"})
 */

@ComponentScan("com.example.two")
@SpringBootApplication
public class TwoApplication {
    private static final Logger LOG = LoggerFactory.getLogger(TwoApplication.class);


    public static void main(String[] args) {


        SpringApplication app = new SpringApplication(TwoApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功！！");
        LOG.info("地址: \thttp://127.0.0.1:{}", env.getProperty("server.port"));

    }

}
