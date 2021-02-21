package softuni.judge.model.service;

public class CommentServiceModel {
    private Integer score;
    private String textContent;
    private String homeworkId;

    public CommentServiceModel() {
    }

    public Integer getScore() {
        return score;
    }

    public CommentServiceModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentServiceModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getHomeworkId() {
        return homeworkId;
    }

    public CommentServiceModel setHomeworkId(String homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }
}
