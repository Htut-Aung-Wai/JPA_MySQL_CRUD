package jpa_crud_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JpaMySqlCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaMySqlCrudApplication.class, args);
    }

}
