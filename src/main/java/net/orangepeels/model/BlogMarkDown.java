package net.orangepeels.model;

import java.util.Date;

public class BlogMarkDown {
    private int id;
    private Date upDate;
    private String fileName;
    private String content;
    private String md5Code;
    private int flag;

    public BlogMarkDown() {
    }

    public BlogMarkDown(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public BlogMarkDown(String fileName, String content, String md5Code) {
        this.fileName = fileName;
        this.content = content;
        this.md5Code = md5Code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    @Override
    public String toString() {
        return "BlogMarkDown{" +
                "id=" + id +
                ", upDate=" + upDate +
                ", fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", md5Code='" + md5Code + '\'' +
                ", flag=" + flag +
                '}';
    }
}
