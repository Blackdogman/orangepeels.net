package net.orangepeels.cotroller;

import net.orangepeels.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCotroller {
    @Autowired
    private UserDao userDao;

    @GetMapping("/")
    public String WelcomeToWebsite(){
        System.out.println(userDao.selectId(1));
        return "homePage";
    }


}
