package net.orangepeels.cotroller;

import net.orangepeels.utils.ValCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/game")
public class GameController {
    private final ValCode valCode;

    @Autowired
    public GameController(ValCode valCode) {
        this.valCode = valCode;
    }

    @RequestMapping("/getValCode.do")
    public void getValCode(HttpServletResponse response) throws IOException {
        valCode.createCode();
        response.setContentType("img/png");
        valCode.write(response.getOutputStream());
    }
}
