package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
