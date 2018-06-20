package net.orangepeels.service;

import net.orangepeels.model.BlogMarkDown;

import java.util.List;
import java.util.TreeMap;

public interface BlogMarkDownService {

    int saveMarkDown(BlogMarkDown blog);
    TreeMap<Integer, List<BlogMarkDown>> getAllBlogMarkDown();
    String getMarkDownByMarkDownId(String markdownId);
}
