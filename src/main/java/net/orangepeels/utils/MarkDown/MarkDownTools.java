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

    public static String getHTML(File file) throws IOException {
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
    private static String getFistLab(File file) throws IOException {
        StringBuilder toLab = new StringBuilder();
        String tag = "";
        boolean ulFlag = false;
        String codeFlag = "";
        InputStream input = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader); // markdown读取器
        String temp;
        while ((temp = br.readLine()) != null){
            tag = temp.substring(0, 1);
            if("-".equals(tag) && ulFlag== false){
                toLab.append("<ul>\r\n");
                ulFlag = true;
            }
            if(!"-".equals(tag) && ulFlag == true){
                toLab.append("</ul>\r\n");
                ulFlag = false;
            }
            switch (tag){
                case "#":
                    toLab.append(hTag(temp));
                    break;
                case "-":
                    toLab.append(liTag(temp));
                    break;
            }
        }
        System.out.println(toLab);
        return toLab.toString();
    }

    //对应无序列表
    private static String liTag(String temp){
        String tab = "";  // 组合的标签
        String start,end; // 记录标签头与标签尾
        start = "<li>";
        end = "</li>";
        tab += start;
        tab += "\r\n";
        tab += temp.substring(temp.indexOf(" "), temp.length());
        tab += "\r\n";
        tab += end;
        tab += "\r\n";
        return tab;
    }

    //生成对应的h1~h6标题
    private static String hTag(String temp){
        String tab = "";  // 组合的标签
        String start,end; // 记录标签头与标签尾
        int hNum = temp.indexOf(" "); //看有几个井号
        start = "<h"+ hNum +">";
        end = "</h"+ hNum +">";
        tab += start;
        tab += "\r\n";
        tab += temp.substring(temp.indexOf(" "), temp.length());
        tab += "\r\n";
        tab += end;
        tab += "\r\n";
        return tab;
    }
}
