package softuni.judge.model.binding;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class CommentAddBindingModel {
    private Integer score;
    private String textContent;
    private String homeworkId;

    public CommentAddBindingModel() {
    }

    @Min(value = 2, message = "Score must be more than 1")
    @Max(value = 6, message = "Score must be less than 7")
    public Integer getScore() {
        return score;
    }

    public CommentAddBindingModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    @Size(min = 3, message = "Text content length must be more than 3")
    public String getTextContent() {
        return textContent;
    }

    public CommentAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public CommentAddBindingModel setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }
}
