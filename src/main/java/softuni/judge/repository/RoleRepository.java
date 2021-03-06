package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Role;
import softuni.judge.model.entity.RoleNameEnum;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleNameEnum roleNameEnum);
}
