package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
}
