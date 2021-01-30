package softuni.judge.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.judge.model.entity.Role;
import softuni.judge.model.entity.RoleNameEnum;
import softuni.judge.model.service.RoleServiceModel;
import softuni.judge.repository.RoleRepository;
import softuni.judge.service.RoleService;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

//    @PostConstruct
//    public void init() {
//        if (this.roleRepository.count() == 0) {
//            Role admin = new Role(RoleNameEnum.ADMIN);
//            Role user = new Role(RoleNameEnum.USER);
//
//            this.roleRepository.saveAndFlush(admin);
//            this.roleRepository.saveAndFlush(user);
//        }
//    }

    @Override
    public RoleServiceModel findByName(RoleNameEnum roleNameEnum) {
        return this.roleRepository.findByName(roleNameEnum)
                .map(role -> this.modelMapper.map(role, RoleServiceModel.class))
                .orElse(null);
    }

    @Override
    public void initRoles() {
        if (this.roleRepository.count() == 0) {
            Role admin = new Role(RoleNameEnum.ADMIN);
            Role user = new Role(RoleNameEnum.USER);

            this.roleRepository.saveAndFlush(admin);
            this.roleRepository.saveAndFlush(user);
       }
    }
}
