package softuni.judge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.judge.security.CurrentUser;

@Controller
public class HomeController extends BaseController {
    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public ModelAndView home() {
        return currentUser.isAnonymous() ? super.view("index") : super.view("home");
    }
}
