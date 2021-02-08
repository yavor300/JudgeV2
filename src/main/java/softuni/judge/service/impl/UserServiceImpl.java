package softuni.judge.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.judge.model.entity.Role;
import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.model.entity.User;
import softuni.judge.model.service.UserServiceModel;
import softuni.judge.repository.UserRepository;
import softuni.judge.security.CurrentUser;
import softuni.judge.service.RoleService;
import softuni.judge.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel
                .setRole(this.roleService.findByName(this.userRepository.count() == 0 ? RoleNameEnum.ADMIN : RoleNameEnum.USER));

        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        return userRepository
                .findByUsernameAndPassword(username, password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void login(UserServiceModel userServiceModel) {
        currentUser.setId(userServiceModel.getId())
                .setUsername(userServiceModel.getUsername())
                .setRole(userServiceModel.getRole().getName());
    }

    @Override
    public void logout() {
        currentUser.setUsername(null)
                .setId(null)
                .setRole(null);
    }

    @Override
    public List<String> findALlUsernames() {
        return userRepository.findAllUsernames();
    }

    @Override
    public void changeRole(String username, RoleNameEnum roleNameEnum) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            if (user.get().getRole().getName() != roleNameEnum) {
                user.get().setRole(modelMapper.map(roleService.findByName(roleNameEnum), Role.class));
                userRepository.save(user.get());
            }
        }
    }
}
