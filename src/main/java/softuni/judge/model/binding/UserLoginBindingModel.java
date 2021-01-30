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

    @Length(min = 2, message = "Username length must be minimum 2 characters.")
    public String getUsername() {
        return username;
    }

    @Length(min = 3, message = "Password length must be minimum 3 characters.")
    public String getPassword() {
        return password;
    }
}
