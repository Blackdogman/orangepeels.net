package net.orangepeels.service;

import net.orangepeels.dao.BlogMarkDownDao;
import net.orangepeels.model.BlogMarkDown;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Resource
public class BlogMarkDownService {
    @Autowired
    private BlogMarkDownDao dao;

    /**
     * 该方法调用mybatis要报空指针异常 需要研究
     * @param blog
     * @return
     */
    public int saveMarkDown(BlogMarkDown blog){
        int result;
        System.out.println(blog);
        System.out.println("blog.getUpDate().toString(): " +blog.getUpDate().toString());
        System.out.println("blog.getFileName(): " + blog.getFileName());
//        System.out.println("blog.getContent(): " + blog.getContent());
        result = dao.insert(blog.getFileName(), blog.getContent());
        return result;
    }
}
