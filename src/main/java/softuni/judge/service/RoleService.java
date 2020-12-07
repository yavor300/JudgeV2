package softuni.judge.service;

import softuni.judge.model.service.RoleServiceModel;

public interface RoleService {
    RoleServiceModel findByName(String name);
}
