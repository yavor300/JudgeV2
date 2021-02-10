package softuni.judge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.judge.model.binding.HomeworkAddBindingModel;
import softuni.judge.service.ExerciseService;
import softuni.judge.service.HomeworkService;

import javax.validation.Valid;

@Controller
@RequestMapping("/homework")
public class HomeworkController extends BaseController {
    private final ExerciseService exerciseService;
    private final HomeworkService homeworkService;

    @Autowired
    public HomeworkController(ExerciseService exerciseService, HomeworkService homeworkService) {
        this.exerciseService = exerciseService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/add")
    public ModelAndView add(Model model) {
        if (!model.containsAttribute("homeworkAddBindingModel")) {
            model.addAttribute("homeworkAddBindingModel", new HomeworkAddBindingModel());
            model.addAttribute("isLate", false);
        }
        model.addAttribute("exNames", exerciseService.findAllNames());
        return super.view("homework-add"  );
    }

    @PostMapping("/add")
    public ModelAndView addConfirm(@Valid @ModelAttribute HomeworkAddBindingModel homeworkAddBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.homeworkAddBindingModel", bindingResult);
            return super.redirect("/homework/add");
        }

        boolean isLate = exerciseService.check(homeworkAddBindingModel.getExercise());

        if (isLate) {
            redirectAttributes.addFlashAttribute("homeworkAddBindingModel", homeworkAddBindingModel);
            redirectAttributes.addFlashAttribute("isLate", true);
        }

        homeworkService.add(homeworkAddBindingModel.getExercise(),
                homeworkAddBindingModel.getGitAddress());


        return super.redirect("/");
    }
}
