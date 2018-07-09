package net.orangepeels.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(public * net.orangepeels.cotroller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void beforeWebLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("客户端IP: " + request.getRemoteAddr());
        System.out.println("访问地址: " + request.getRequestURI());
    }
}
