package net.orangepeels.cotroller.frame;

import net.orangepeels.service.BlogMarkDownService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServlet;

public class BaseController extends HttpServlet {
    @Autowired
    protected BlogMarkDownService blogMarkDownService;
}
