package softuni.judge.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.judge.model.binding.UserRegisterBindingModel;
import softuni.judge.model.service.UserServiceModel;
import softuni.judge.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

//    @PostMapping("/login")
//    public ModelAndView loginConfirm() {
//        return new ModelAndView()
//    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel") UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            //TODO VALIDATION
            modelAndView.setViewName("redirect:/users/register");
        } else {
            UserServiceModel userServiceModel = this.userService.registerUser(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));

            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }
}
