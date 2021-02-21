package softuni.judge.service;

import softuni.judge.model.entity.Homework;
import softuni.judge.model.service.HomeworkServiceModel;

public interface HomeworkService {
    void add(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();

    Homework findById(String homeworkId);
}
