package softuni.judge.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.judge.model.view.HomeworkViewModel;
import softuni.judge.service.HomeworkService;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentController(HomeworkService homeworkService, ModelMapper modelMapper) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        HomeworkViewModel homework = modelMapper.map(
                homeworkService.findHomeworkForScoring(), HomeworkViewModel.class
        );

        model.addAttribute("homework", homework);
        return "homework-check";
    }
}
