package net.orangepeels.cotroller;

import net.orangepeels.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCotroller {

    @GetMapping("/")
    public String WelcomeToWebsite(){
        return "homePage";
    }


}
