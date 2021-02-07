package softuni.judge.model.service;

import softuni.judge.model.entity.RoleNameEnum;

public class RoleServiceModel extends BaseServiceModel {
    private RoleNameEnum name;

    public RoleServiceModel() {
    }


    public RoleNameEnum getName() {
        return name;
    }

    public RoleServiceModel setName(RoleNameEnum name) {
        this.name = name;
        return this;
    }
}
