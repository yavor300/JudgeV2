package softuni.judge.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.judge.model.entity.Exercise;
import softuni.judge.model.service.ExerciseServiceModel;
import softuni.judge.repository.ExerciseRepository;
import softuni.judge.service.ExerciseService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository, ModelMapper modelMapper) {
        this.exerciseRepository = exerciseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        exerciseRepository.saveAndFlush(modelMapper.map(exerciseServiceModel, Exercise.class));
    }

    @Override
    public List<String> findAllNames() {
        return exerciseRepository.findAllNames();
    }

    @Override
    public boolean check(String exercise) {
        Exercise exerciseEntity = exerciseRepository.findByName(exercise)
                .orElse(null);
        return exerciseEntity.getDueDate().isBefore(LocalDateTime.now());
    }

    @Override
    public Exercise findByName(String exercise) {
        return exerciseRepository.findByName(exercise).orElse(null);
    }
}
