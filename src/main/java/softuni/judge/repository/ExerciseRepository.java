package softuni.judge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.judge.model.entity.Exercise;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    @Query("select e.name from Exercise e order by e.name")
    List<String> findAllNames();

    Optional<Exercise> findByName(String name);
}
