package se.nackademin.pagebeans;

import se.nackademin.services.UserHandler;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by MacsMac on 2017-04-19.
 */
@Named
@RequestScoped
public class LoginBean {


    @Inject
    private UserHandler userHandler;
    private String password;
    private String userName;

    public String doLogin() {
        return userHandler.doLogin(userName, password) ? "outcomes/loginSuccess" : "Wrong password or username";
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
}