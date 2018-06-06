package net.orangepeels.utils.MarkDown;

import org.junit.Test;

import java.io.*;

public class MarkDownTools {

    @Test
    public void testThisShit(){
        File file = new File("/Users/Blackdogman/Desktop/markdown.md");
        try {
            getHTML(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHTML(File file) throws IOException {
        String strHTML = "";
        strHTML = getFistLab(file);
        return strHTML;
    }

    /**
     * 先把markdown转换成HTML标签
     * @param file
     * @return
     * @throws IOException
     */
    private String getFistLab(File file) throws IOException {
        String toLab = "";
        InputStream input = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String temp = "";
        while ((temp = br.readLine()) != null){
            toLab += getFistLabTab(temp) + "\r\n";
        }
        System.out.println(toLab);
        return toLab;
    }

    /**
     * 逐行处理markdown
     * @param temp 每行的文本
     * @return 对应的HTML文本
     */
    private String getFistLabTab(String temp){
        String tab = "";
        String tag = temp.substring(0, 1);
        if("#".equals(tag)){
            int hNum = temp.indexOf(" "); //看有几个井号
            String start,end;
            start = "<h"+ hNum +">";
            end = "</h"+ hNum +">";
            tab += start + "\r\n";
            tab += temp.substring(temp.indexOf(" "), temp.length());
            tab += "\r\n" + end;
            System.out.println(tab);
        }else {
            tab = temp;
        }
        return tab;
    }
}
