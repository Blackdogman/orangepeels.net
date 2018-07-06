package net.orangepeels.cotroller;

import net.orangepeels.cotroller.frame.BaseController;
import net.orangepeels.model.BlogMarkDown;
import net.orangepeels.service.BlogMarkDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.TreeMap;

@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    @RequestMapping("/blogUi.do")
    public String goToBlogPage(Model model){
        TreeMap<Integer, List<BlogMarkDown>> blogMap = blogMarkDownService.getAllBlogMarkDown();
        model.addAttribute("blogMap", blogMap.descendingMap());
        return "blog/blogHome";
    }
}
