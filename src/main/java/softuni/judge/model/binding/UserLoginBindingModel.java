package softuni.judge.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserLoginBindingModel {
    private String username;
    private String password;


    public UserLoginBindingModel() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Length(min = 2, max = 10, message = "Username must be more than 2 characters")
    public String getUsername() {
        return username;
    }

    @Length(min = 3, max = 10, message = "Username must be more than 3 characters")
    public String getPassword() {
        return password;
    }
}
