package softuni.judge.model.view;


public class HomeworkViewModel {
    private String id;
    private String gitAddress;

    public HomeworkViewModel() {
    }

    public String getId() {
        return id;
    }

    public HomeworkViewModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkViewModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
