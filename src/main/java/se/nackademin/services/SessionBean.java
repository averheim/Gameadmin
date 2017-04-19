package se.nackademin.services;

import se.nackademin.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Christopher Olsson on 2017-04-19.
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private User currentUser;

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void doLogout() {
        this.currentUser = null;
    }
}
