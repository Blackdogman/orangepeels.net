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
     * 存储一个markdown
     * @param blog
     * @return
     */
    public int saveMarkDown(BlogMarkDown blog){
        return dao.insert(blog.getFileName(), blog.getContent(), blog.getMd5Code());
    }
}
