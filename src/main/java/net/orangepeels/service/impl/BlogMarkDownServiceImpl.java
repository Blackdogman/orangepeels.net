package net.orangepeels.service.impl;

import net.orangepeels.dao.BlogMarkDownDao;
import net.orangepeels.model.BlogMarkDown;
import net.orangepeels.service.BlogMarkDownService;
import net.orangepeels.utils.DateTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogMarkDownServiceImpl implements BlogMarkDownService {

    @Autowired
    private BlogMarkDownDao blogMarkDownDao;

    /**
     * 存储一个markdown
     * @param blog
     * @return
     */
    public int saveMarkDown(BlogMarkDown blog){
        return blogMarkDownDao.insert(blog.getFileName(), blog.getContent(), blog.getMd5Code());
    }

    /**
     * 得到所有的markdown
     * @return Map对象 key:对应的每天的时间, value:对应时间中的markdown集合
     */
    public TreeMap<Integer, List<BlogMarkDown>> getAllBlogMarkDown(){
        List<BlogMarkDown> allBlogMarkDown = blogMarkDownDao.selectAll();
        Collections.reverse(allBlogMarkDown);
        TreeMap<Integer, List<BlogMarkDown>> blogs = new TreeMap<>();
        int dateFlag = -1;
        int tempDate;
        List<BlogMarkDown> tempList = null;
        for (BlogMarkDown item:
            allBlogMarkDown ) {
            tempDate = Integer.parseInt(DateTools.simpleDateString(item.getUpDate()));
            if(tempDate == dateFlag){
                tempList.add(item); //如果还是那天的，直接加入集合
            }else {
                tempList = new ArrayList<>(); //清空tempList
                tempList.add(item); //把当前这个item加入新的集合中
                dateFlag = tempDate; //把dateFlag设置为新的tempdate
                blogs.put(dateFlag, tempList); //当日期字符串不同的时候，把当前的tempList加入集合
            }
        }
        if(tempList.size() != 0){
            blogs.put(dateFlag, tempList);
        }
        return blogs;
    }

    public String getMarkDownByMarkDownId(String markdownId) {
        BlogMarkDown markDown = blogMarkDownDao.select(markdownId);
        String markDownText = markDown.getContent();
        return markDownText;
    }
}
