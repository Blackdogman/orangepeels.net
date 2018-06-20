package net.orangepeels.cotroller;

import net.orangepeels.model.BlogMarkDown;
import net.orangepeels.service.BlogMarkDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.TreeMap;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogMarkDownService service;

    @RequestMapping("/blogUi.do")
    public String goToBlogPage(HttpServletRequest req){
        TreeMap<Integer, List<BlogMarkDown>> blogMap = service.getAllBlogMarkDown();
        req.setAttribute("blogMap", blogMap.descendingMap());
        return "blog/blogHome";
    }
}
