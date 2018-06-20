package net.orangepeels.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @GetMapping("/")
    public String WelcomeToWebsite(){
        return "homePage";
    }

    @GetMapping("/playground")
    public String goToPlayground(){
        return "study/playground";
    }

}