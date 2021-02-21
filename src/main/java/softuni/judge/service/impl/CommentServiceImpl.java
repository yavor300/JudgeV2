package softuni.judge.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.judge.model.entity.Comment;
import softuni.judge.model.service.CommentServiceModel;
import softuni.judge.repository.CommentRepository;
import softuni.judge.security.CurrentUser;
import softuni.judge.service.CommentService;
import softuni.judge.service.HomeworkService;
import softuni.judge.service.UserService;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final HomeworkService homeworkService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, HomeworkService homeworkService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.homeworkService = homeworkService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(CommentServiceModel commentServiceModel, String homeworkId) {
        Comment comment = modelMapper.map(commentServiceModel, Comment.class);
        comment.setAuthor(userService.findById(currentUser.getId()));
        comment.setHomework(homeworkService.findById(homeworkId));
        commentRepository.save(comment);
    }
}
