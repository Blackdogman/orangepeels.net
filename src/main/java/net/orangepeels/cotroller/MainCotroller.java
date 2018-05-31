package net.orangepeels.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainCotroller {

    @GetMapping("/")
    public String WelcomeToWebsite(){
        return "homePage";
    }


}
