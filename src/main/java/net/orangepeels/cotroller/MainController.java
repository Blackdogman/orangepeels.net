package net.orangepeels.cotroller;

import net.orangepeels.dao.BlogMarkDownDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @Autowired
    private BlogMarkDownDao blogMarkDownDao;

    @GetMapping("/")
    public String WelcomeToWebsite(){
        System.out.println(blogMarkDownDao.testGetANumber());
        return "homePage";
    }

    @GetMapping("/playground")
    public String goToPlayground(){
        return "study/playground";
    }

}
