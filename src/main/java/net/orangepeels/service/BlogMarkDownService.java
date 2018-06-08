package net.orangepeels.service;

import net.orangepeels.dao.BlogMarkDownDao;
import net.orangepeels.model.BlogMarkDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogMarkDownService {

    @Autowired
    private BlogMarkDownDao dao;

    /**
     * 该方法调用mybatis要报空指针异常 需要研究
     * @param blog
     * @return
     */
    public int saveMarkDown(BlogMarkDown blog){
        return dao.insert(blog.getFileName(), blog.getContent(), blog.getMd5Code());
    }
}
