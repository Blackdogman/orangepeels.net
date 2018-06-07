package net.orangepeels.cotroller.studycontroller;

import net.orangepeels.utils.MarkDownTools;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class StudyController {

    /**
     * 文件上传
     * @param file 对应的上传文件
     * @// TODO: 2018/6/7 并没有完成，不知道该怎么做
     */
    @RequestMapping("/upFile")
    public String upFile(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("file: " + file);
        System.out.println(file.getOriginalFilename());
        InputStream input = file.getInputStream();
        String re = MarkDownTools.getHTML(input);
        return re;
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
