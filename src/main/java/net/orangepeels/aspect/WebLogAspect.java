package net.orangepeels.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class WebLogAspect {

    @Pointcut("execution(public * net.orangepeels.cotroller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void beforeWebLog() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuilder sb = new StringBuilder();
        sb.append("访问时间: ").append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        sb.append("\r\n");
        sb.append("客户端IP: " + request.getRemoteAddr());
        sb.append("\r\n");
        sb.append("访问地址: " + request.getRequestURI());
        sb.append("\r\n\r\n");
        String path = System.getProperty("user.dir");
        //得到项目发布路径
        //String path = Class.class.getClass().getResource("/").getPath();
        String yMd = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file = new File(path + "/log-Orangepeels/log"+yMd+".txt");
        if(!file.getParentFile().getParentFile().getParentFile().exists()){
            file.getParentFile().getParentFile().getParentFile().mkdir();
        }
        if(!file.getParentFile().getParentFile().exists()){
            file.getParentFile().getParentFile().mkdir();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            byte[] tempStr = sb.toString().getBytes();
            fileOutputStream.write(tempStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
