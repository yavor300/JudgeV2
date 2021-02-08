package softuni.judge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.service.UserService;

@Controller
@RequestMapping("/roles")
public class RoleController extends BaseController {
    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.addObject("names", userService.findALlUsernames());
        return super.view("role-add", modelAndView);
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@RequestParam String username, @RequestParam String role) {
        userService.changeRole(username, RoleNameEnum.valueOf(role.toUpperCase()));
        return super.redirect("/");
    }
}
