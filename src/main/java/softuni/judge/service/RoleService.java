package softuni.judge.service;

import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.model.service.RoleServiceModel;

public interface RoleService {
    RoleServiceModel findByName(RoleNameEnum roleNameEnum);

    void initRoles();
}
