package softuni.judge.service;

import softuni.judge.model.service.HomeworkServiceModel;

public interface HomeworkService {
    void add(String exercise, String gitAddress);

    HomeworkServiceModel findHomeworkForScoring();
}
