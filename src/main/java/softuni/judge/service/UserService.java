package softuni.judge.service;

import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.model.entity.User;
import softuni.judge.model.service.UserServiceModel;
import softuni.judge.model.view.UserProfileViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findALlUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    User findById(String id);

    UserProfileViewModel findProfileById(String id);
}
