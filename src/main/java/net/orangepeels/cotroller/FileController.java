package net.orangepeels.cotroller;

import net.orangepeels.model.BlogMarkDown;
import net.orangepeels.service.BlogMarkDownService;
import net.orangepeels.utils.MarkDownTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private BlogMarkDownService blogMarkDownService;

    /**
     * 文件上传
     * @param file 对应的上传文件
     */
    @RequestMapping("/uploadMarkDown")
    public int upFile(MultipartFile file) throws IOException {
        byte[] item = new byte[10000];
        String fileName = file.getOriginalFilename();
        StringBuilder content = new StringBuilder();
        InputStream input = file.getInputStream();
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String temp;
        while((temp = br.readLine()) != null){
            content.append(temp).append("\r\n");
        }
        input.read(item);
        BlogMarkDown blog = new BlogMarkDown(fileName, content.toString());
        int reRow = blogMarkDownService.saveMarkDown(blog);
        return reRow;
    }

    /**
     * 把markdown转换成HTML代码返回
     * @return 返回一个HTML代码
     */
    @RequestMapping("/getHTMLFromMD")
    public String getHTMLFromMD(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String reStr = "";
        try {
            reStr = MarkDownTools.getHTML(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reStr;
    }

    /**
     * 从数据库获得markdown，并转换为html
     * @param markdownId markdown的id
     * @return html代码
     * @throws IOException
     */
    @RequestMapping("/getHTMLFromDBMD")
    public String getHTMLFromDBMD(String markdownId) throws IOException {
        String markdownText = blogMarkDownService.getMarkDownByMarkDownId(markdownId);
        String[] textList = markdownText.split("\r\n");
        String htmlText = MarkDownTools.getHTMl(textList);
        return htmlText;
    }
}
