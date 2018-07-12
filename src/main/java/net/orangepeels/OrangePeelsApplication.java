package net.orangepeels;

import net.orangepeels.component.interceptor.NothingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@ServletComponentScan
public class OrangePeelsApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(OrangePeelsApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new NothingInterceptor()).addPathPatterns("/ICantDoAnything");
    }
}
