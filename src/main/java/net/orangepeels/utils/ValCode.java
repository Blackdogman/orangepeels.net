package net.orangepeels.utils;



import java.awt.Color;



import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;


/**
 * 验证码生产类
 * @author wj
 *
 */
@Component
public class ValCode {

    // 图片的宽度。  
    private int width = 160;  
    // 图片的高度。  
    private int height = 40;  
    // 验证码字符个数  
    private int codeCount = 4;  
    // 验证码干扰线数  
    private int lineCount = 150;  
    // 验证码  
    private String code = null;  


	// 图片对象 
    private BufferedImage buffImg = null;  
  
    // 验证码范围,去掉0(数字)和O(拼音)容易混淆的(小写的1和L也可以去掉,大写不用了)  
    private char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',  
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',  
            'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
    /**
     * 生成验证的方法
     */
    public void createCode() {  
    	//声明几个画图需要的几个变量
        int x = 0;
        
        int red = 0, green = 0, blue = 0;  
        
        //设置字符的间距
        x = width / (codeCount + 2);
    
   
  
        // 创建一个设置rgb颜色图片对象 ,设置这个图片的像素是width*height,采用rgb颜色来设置颜色
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        //创建一个画2D图对象，可以理解为它是一个画画需要的工具盒
        Graphics2D g = buffImg.createGraphics();  
        
        //----------------先画一个矩形作为验证码图片背景色--------------------
        //设置画笔的颜色，拿出绿色画笔
        g.setColor(Color.green);  
        //用绿色画笔画一个矩形，参数0，0是起始画笔的坐标，width,height是要画矩形的宽高度
        g.fillRect(0, 0, width, height); 
        
        
        //-------------------画干扰线开始------------------------
        // 创建随机数对象
        Random random = new Random();  
        //这个循环用来生成干扰线的
        for (int i = 0; i < lineCount; i++) {  
            // 生成干扰线的随机坐标,nextInt(100)函数是随机生成一个1到100的随机数
            int xs = random.nextInt(width);//x坐标开始  
            int ys = random.nextInt(height);//y坐标开始  
            int xe = xs + random.nextInt(width / 8);//x坐标结束  
            int ye = ys + random.nextInt(height / 8);//y坐标结束  
  
            // 产生随机的颜色值，让输出的每个干扰线的颜色值都将不同。  
            red = random.nextInt(255);  
            green = random.nextInt(255);  
            blue = random.nextInt(255); 
         
            //设置干扰线的颜色
            g.setColor(new Color(red, green, blue)); 
            //画出干扰线
            g.drawLine(xs, ys, xe, ye);  
        }  
    
        
        
      //--------------------画四个字符--------------------
        // 创建字体对象,三个参数分别是字体，字体风格，字体大小
        Font font = new Font("Courier", Font.PLAIN, 38);  
        //给画笔设置字体
        g.setFont(font);  
        
        // 创建一个StringBuffer对象，用来记录生成验证码的值的
        StringBuffer randomCode = new StringBuffer();  
    
         //这个循环用来随机生成字符验证码的
        for (int i = 0; i < codeCount; i++) {  
        	//随机取到字符组codeSequence取一个字符，并把它转换成字符串类型
            String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]); 
            
            // 产生随机的颜色值，让输出的每个字符的颜色值都将不同。  
            red = random.nextInt(255);  
            green = random.nextInt(255);  
            blue = random.nextInt(255);  
            //设置字符的颜色
            g.setColor(new Color(red, green, blue)); 
            //画出字符，三个参数分别是：要画的字，字的x坐标,y坐标
            g.drawString(strRand, (i + 1) * x, height - 4);  
            // 将产生的四个随机数组合在一起。  
            randomCode.append(strRand); 
        
            
        }  
        System.out.println(randomCode);
        // 将四位数字的验证码传给属性code
        code = randomCode.toString();  
    }  
    /**
     * 生成图片
     * @param sos
     * @throws IOException
     */
    public void write(OutputStream sos) throws IOException {  
    	//将buffImg生成png格式的图片，OutputStream是输出对象方式
        ImageIO.write(buffImg, "png", sos); 
        //关闭流
        sos.close();    
    }  
}
