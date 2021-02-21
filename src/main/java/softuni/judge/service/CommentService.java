package softuni.judge.service;

import softuni.judge.model.service.CommentServiceModel;

public interface CommentService {
    void add(CommentServiceModel commentServiceModel, String homeworkId);
}
