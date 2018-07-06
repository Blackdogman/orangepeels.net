package net.orangepeels;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("net.orangepeels.mapper.*")
public class OrangePeelsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrangePeelsApplication.class, args);
    }
}
