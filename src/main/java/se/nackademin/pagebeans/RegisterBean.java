package se.nackademin.pagebeans;


import se.nackademin.domain.User;
import se.nackademin.services.UserHandler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * @author christopherolsson
 */
@Named
@RequestScoped
public class RegisterBean {

    private String userName;
    private String password;
    private String email;


    @Inject
    private UserHandler userHandler;

    public String doRegister() {
        String successMessage = "outcomes/registrationSuccess.xhtml";
        String failMessage = "User '" + userName + "' is already registered";
        User newUser = new User(userName, password, email);
        return userHandler.doRegister(newUser) ? successMessage : failMessage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
