package net.orangepeels.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬虫类
 */
public class CrawlerTools {

    public static void crawlerImg(String url, String downloadPath) throws IOException {
        List<String> imgUrlList = new ArrayList<>();
        URL urlC = new URL(url);
        urlC.openConnection();
        InputStream htmlStream = urlC.openStream();
        byte[] readr = new byte[128];
        StringBuilder sb = new StringBuilder();
        while (htmlStream.read(readr) > 0) {
            sb.append(new String(readr));
            readr = new byte[128];
        }
        Pattern p = Pattern.compile("<img.*src=(.*?)[^>]*?>", Pattern.CASE_INSENSITIVE);
        // 现在创建 matcher 对象
        Matcher m = p.matcher(sb.toString());
        while (m.find()) {
            String temp = m.group(0);
            Matcher m2 = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(temp);
            while (m2.find()) {
                String imgUrl = m2.group(0).substring(5, m2.group(0).length() - 1);
                imgUrlList.add(imgUrl);
            }
        }
        for (String item : imgUrlList) {
            if (!"".equals(item) && item != null) {
                FileDownloadTools.downLoadFile(item.replace("\'", ""), downloadPath);
            }
        }
    }
}
