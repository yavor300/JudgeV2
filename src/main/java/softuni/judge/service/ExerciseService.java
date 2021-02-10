package softuni.judge.service;

import softuni.judge.model.entity.Exercise;
import softuni.judge.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {
    void addExercise(ExerciseServiceModel exerciseServiceModel);

    List<String> findAllNames();

    boolean check(String exercise);

    Exercise findByName(String exercise);
}
