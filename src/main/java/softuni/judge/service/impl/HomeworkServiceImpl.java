package softuni.judge.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.judge.model.entity.Homework;
import softuni.judge.model.service.HomeworkServiceModel;
import softuni.judge.repository.HomeworkRepository;
import softuni.judge.security.CurrentUser;
import softuni.judge.service.ExerciseService;
import softuni.judge.service.HomeworkService;
import softuni.judge.service.UserService;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ExerciseService exerciseService;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ExerciseService exerciseService, CurrentUser currentUser, UserService userService, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.exerciseService = exerciseService;
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(String exercise, String gitAddress) {
        Homework homework = new Homework();
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homework.setExercise(exerciseService.findByName(exercise));
        homework.setAuthor(userService.findById(currentUser.getId()));

        homeworkRepository.save(homework);
    }

    @Override
    public HomeworkServiceModel findHomeworkForScoring() {
        return homeworkRepository
                .findTop1ByOrderByComments()
                .map(homework -> modelMapper.map(homework, HomeworkServiceModel.class))
                .orElse(null);
    }

    @Override
    public Homework findById(String homeworkId) {
        return homeworkRepository.findById(homeworkId)
                .orElse(null);
    }
}
