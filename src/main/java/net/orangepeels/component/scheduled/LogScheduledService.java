package net.orangepeels.component.scheduled;

import net.orangepeels.utils.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LogScheduledService {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(cron = "1 59 23 1/1 * ?")
    public void sendLogMailEveryDay(){
        String path = System.getProperty("user.dir");
        String yMd = simpleDateFormat.format(new Date());
        // 访问日志文件，作为附件发送
        File file = new File(path + "/log-Orangepeels/log"+yMd+".txt");
        MailSender mailSender = new MailSender();
        mailSender.setToAddress("superkidchy@foxmail.com");
        mailSender.setSubject("OrangePeels-" + simpleDateFormat.format(new Date()) + "-visitLog");
        mailSender.setContent("N/A");
        mailSender.setMailFile(file);
        mailSender.send();
    }
}
