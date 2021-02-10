package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Homework;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, String> {

}
