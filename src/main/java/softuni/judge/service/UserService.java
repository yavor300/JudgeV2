package softuni.judge.service;

import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findALlUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);
}
