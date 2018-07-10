package net.orangepeels.cotroller;

import net.orangepeels.cotroller.frame.BaseController;
import net.orangepeels.dao.BlogMarkDownDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UrlController extends BaseController {
    @GetMapping("/")
    public String WelcomeToWebsite(){
        return "homePage";
    }

    @GetMapping("/playground")
    public String goToPlayground(){
        return "study/playground";
    }

    @GetMapping("/test")
    public String test(){
        System.out.println("test");
        System.out.println("hello");
        return "homePage";
    }
}
