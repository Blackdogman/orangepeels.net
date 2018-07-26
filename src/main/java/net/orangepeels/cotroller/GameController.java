package net.orangepeels.cotroller;

import net.orangepeels.utils.ValCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/game")
public class GameController {
    private final ValCode valCode;

    @Autowired
    public GameController(ValCode valCode) {
        this.valCode = valCode;
    }

    @RequestMapping("/getValCode.do")
    public void getValCode(HttpServletResponse response, HttpSession session) throws IOException {
        Object[] valCodeBuffer = valCode.createCode();
        session.setAttribute("gameValCode", valCode.getCode());
        response.setContentType("img/png");
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) valCodeBuffer[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

    @RequestMapping("/submitGameCode.do")
    public int submitGameCode(String number1, String number2, String number3, String number4, HttpSession session) {
        String gameValCode = (String) session.getAttribute("gameValCode");
        String answer = number1 +
                number2 +
                number3 +
                number4;
        if (gameValCode.equalsIgnoreCase(answer)) {
            return 1;
        } else {
            return 0;
        }
    }
}
