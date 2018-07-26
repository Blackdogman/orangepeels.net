package net.orangepeels.cotroller;

import net.orangepeels.cotroller.frame.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/gameStation")
    public String goToGameStation(){
        return "gameStation/gameStationMain";
    }

    @GetMapping("/gameStation/valCodeGame")
    public String goToValCodeGame(){
        return "gameStation/valCodeGame";
    }
}
