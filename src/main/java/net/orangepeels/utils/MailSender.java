package net.orangepeels.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 邮件发送类
 */
public class MailSender implements Runnable {
    private static final String FROM_ADDRESS = "superkidchy@foxmail.com";
    private static final String SMTP_HOST = "smtp.qq.com";
    private static final String SMTP_KEY = "bW90aGVyand1amRsb2FveHZjYmNkZQ==";

    private String toAddress;
    private String fromAddress;
    private String smtpHost;

    private String subject;
    private Object content;

    @Override
    public void run() {
        this.send();
    }

    /**
     * 发送邮件
     */
    public void send() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", this.getStmpHost());
        properties.put("mail.smtp.auth", "true");
        try {
            String key = new String(EncryptTools.decryptBASE64(SMTP_KEY));
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_ADDRESS, key); //发件人邮件用户名、密码
                }
            });
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // Set From: 头部头字段
            message.setFrom(new InternetAddress(this.fromAddress));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.toAddress));
            // Set Subject: 头部头字段
            message.setSubject(this.subject);
            // 设置消息体
            message.setContent(this.content, "text/html;charset=utf-8");
            // 发送消息
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public MailSender(String toAddress, String subject, Object content) {
        this.fromAddress = FROM_ADDRESS;
        this.smtpHost = SMTP_HOST;
        this.toAddress = toAddress;
        this.subject = subject;
        this.content = content;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getStmpHost() {
        return smtpHost;
    }

    public void setStmpHost(String stmpHost) {
        this.smtpHost = stmpHost;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        content = content;
    }
}
