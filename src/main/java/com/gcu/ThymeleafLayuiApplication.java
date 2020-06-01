package com.gcu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@MapperScan
public class ThymeleafLayuiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafLayuiApplication.class, args);
    }

}
