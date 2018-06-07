package net.orangepeels.cotroller.studycontroller;

import net.orangepeels.utils.MarkDownTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class StudyController {

    /**
     * 文件上传
     * @param req
     * @// TODO: 2018/6/7 并没有完成，不知道该怎么做
     */
    @RequestMapping("/upFile")
    public void upFile(HttpServletRequest req){
        String file = req.getParameter("file");
        System.out.println("file: " + file);
    }

    /**
     * 把markdown转换成HTML代码返回
     * @return 返回一个HTML代码
     */
    @RequestMapping("/getHTMLFromMD")
    public String getHTMLFromMD(HttpServletRequest req){
        String path = req.getParameter("file");
        System.out.println(path);
        String reStr = "";
        File file = new File(path);
        try {
            reStr = MarkDownTools.getHTML(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reStr;
    }
}
