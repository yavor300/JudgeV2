package softuni.judge.model.service;


import java.time.LocalDateTime;

public class HomeworkServiceModel {
    private String id;
    private LocalDateTime addedOn;
    private String gitAddress;
    private UserServiceModel author;

    public HomeworkServiceModel() {
    }

    public String getId() {
        return id;
    }

    public HomeworkServiceModel setId(String id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public HomeworkServiceModel setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkServiceModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public UserServiceModel getAuthor() {
        return author;
    }

    public HomeworkServiceModel setAuthor(UserServiceModel author) {
        this.author = author;
        return this;
    }
}
