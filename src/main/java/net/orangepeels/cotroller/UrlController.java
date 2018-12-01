package net.orangepeels.cotroller;

import net.orangepeels.cotroller.frame.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrlController extends BaseController {
    @GetMapping("/oldhome")
    public String WelcomeToWebsite(){
        return "homePage";
    }

    @GetMapping("/")
    public String WhatFuckIsThis(){
        return "whatFuckIsThis";
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

    @GetMapping("/bigblack/missionGet")
    public String gotoBBmissionGet(){
        return "bigblack/missionGet";
    }

    @GetMapping("/bigblack/missionSet")
    public String gotoBBmissionSet(){
        return "bigblack/missionSet";
    }
}
