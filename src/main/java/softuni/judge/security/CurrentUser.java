package softuni.judge.security;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import softuni.judge.model.entity.RoleNameEnum;

@Component
@SessionScope
public class CurrentUser {
    private String id;
    private String username;
    private RoleNameEnum role;

    public CurrentUser() {
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setId(String id) {
        this.id = id;
        return this;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public RoleNameEnum getRole() {
        return role;
    }

    public CurrentUser setRole(RoleNameEnum role) {
        this.role = role;
        return this;
    }

    public boolean isAnonymous() {
        return username == null;
    }

    public boolean isAdmin() {
        return role == RoleNameEnum.ADMIN;
    }
}
