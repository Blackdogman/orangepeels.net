package net.orangepeels.utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

/**
 * 邮件发送类
 */
public class MailSender implements Runnable {
    private static final String FROM_ADDRESS = "superkidchy@foxmail.com";
    private static final String SMTP_HOST = "smtp.qq.com";
    private static final String SMTP_KEY = "bW90aGVydmtodGtobHF6aXlsYmNiZw==";

    private String toAddress;
    private String subject;
    private Object content;
    private File mailFile;

    @Override
    public void run() {
        this.send();
    }

    /**
     * 发送邮件
     */
    public void send() {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTP_HOST);
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
            message.setFrom(new InternetAddress(FROM_ADDRESS));
            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.toAddress));
            // Set Subject: 头部头字段
            message.setSubject(this.subject);
            // 设置消息体
            Multipart multipart = new MimeMultipart();
            //邮件正文
            if (mailFile != null) {
                //邮件附件
                BodyPart contentPart = new MimeBodyPart();
                contentPart.setContent(this.content, "text/html;charset=utf-8");
                multipart.addBodyPart(contentPart);
                BodyPart attachmentPart = new MimeBodyPart();
                DataSource source = new FileDataSource(mailFile);
                attachmentPart.setDataHandler(new DataHandler(source));
                //避免中文乱码的处理
                attachmentPart.setFileName(MimeUtility.encodeWord(mailFile.getName()));
                multipart.addBodyPart(attachmentPart);
                message.setContent(multipart);
            } else {
                message.setContent(this.content, "text/html;charset=utf-8");
            }
            // 发送消息
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "MailSender{" +
                "toAddress='" + toAddress + '\'' +
                ", subject='" + subject + '\'' +
                ", content=" + content +
                ", mailFile=" + mailFile +
                '}';
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
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
        this.content = content;
    }

    public File getMailFile() {
        return mailFile;
    }

    public void setMailFile(File mailFile) {
        this.mailFile = mailFile;
    }


}
