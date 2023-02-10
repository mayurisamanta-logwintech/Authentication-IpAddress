package com.logwintech.Authentication.service;

import com.logwintech.Authentication.entity.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    User signup (User user);

    String homepage ();

    User getUser (Integer id);

    User addUser(User user);



}
