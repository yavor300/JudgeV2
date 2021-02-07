package softuni.judge.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/exercises")
public class ExerciseController extends BaseController {
    @GetMapping("/add")
    public ModelAndView add() {
        return super.view("exercise-add");
    }
}
