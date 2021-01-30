package softuni.judge.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.judge.service.RoleService;

@Component
public class DatabaseInit implements CommandLineRunner {
    private final RoleService roleService;

    @Autowired
    public DatabaseInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
    }
}
