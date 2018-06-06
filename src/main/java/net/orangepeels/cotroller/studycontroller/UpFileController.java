package net.orangepeels.cotroller.studycontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UpFileController {

    @RequestMapping("/upFile")
    public void upFile(HttpServletRequest req){
        String file = req.getParameter("file");
        System.out.println("file: " + file);
    }
}
