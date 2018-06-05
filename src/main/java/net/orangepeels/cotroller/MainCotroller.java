package net.orangepeels.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainCotroller {

    @GetMapping("/")
    public String WelcomeToWebsite(HttpServletRequest req, HttpServletResponse resp){
        Cookie[] cookies = req.getCookies();
        for (Cookie cok:
             cookies) {
            if("users".equals(cok.getName())){
                System.out.println(cok.getValue());
            }
        }
        Cookie c = new Cookie("users", req.getSession().getId());
        resp.addCookie(c);
        return "homePage";
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<String> getJSON(HttpServletRequest req){
        List<String> list = new ArrayList<>();
        list.add(req.getParameter("user_name"));
        list.add(req.getParameter("user_pwd"));
        return list;
    }

}
