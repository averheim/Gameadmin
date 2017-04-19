/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.services;

import se.nackademin.backend.FakeDB;
import se.nackademin.custom_exceptions.SessionUnavailableException;
import se.nackademin.domain.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.SessionException;
import java.io.Serializable;
import java.util.Map;

/**
 * @author christopherolsson
 */
@Named
@SessionScoped
public class UserHandler implements Serializable {

    Map<String, User> users = FakeDB.getInstance();

    @Inject
    SessionBean sessionBean;

    public User doRegister(User selectedUser) {
        User user = users.get(selectedUser.getUserName());
        if (user == null) {
            users.put(selectedUser.getUserName(), selectedUser);
        }
        return user;
    }

    public boolean doLogin(String userName, String password){

        User user = users.get(userName);
        if (user != null) {
            if(user.getPassword().equals(password)){
                sessionBean.setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public User getCurrentUser() throws SessionUnavailableException {
        return getSessionBean().getCurrentUser();
    }

    public SessionBean getSessionBean() throws SessionUnavailableException {
        if (sessionBean == null) {
            throw new SessionUnavailableException("Failed to inject session bean");
        }
        return sessionBean;
    }

    public String doLogout() {
        sessionBean.doLogout();
        return "/index.xhtml";
    }



}
