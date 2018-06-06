package net.orangepeels.utils;

import org.junit.Test;

import java.io.*;

public class MarkDownTools {

    @Test
    public void testThisShit(){
        File file = new File("/Users/Blackdogman/Desktop/markdown.md");
        try {
            System.out.println(getFistLab(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFistLab(File file) throws IOException {
        String toLab = "";
        InputStream input = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(input);
        BufferedReader br = new BufferedReader(reader);
        String temp = "";
        while ((temp = br.readLine()) != null){
            toLab += temp + "\r\n";
        }
        return toLab;
    }
}
