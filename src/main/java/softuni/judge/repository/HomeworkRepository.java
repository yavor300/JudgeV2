package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Homework;

import java.util.Optional;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, String> {
    Optional<Homework> findTop1ByOrderByComments();
}
