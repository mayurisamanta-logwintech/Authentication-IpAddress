package com.logwintech.Authentication.service;

import com.logwintech.Authentication.entity.User;
import com.logwintech.Authentication.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository uRepo;


    @Override
    public User signup(User user) {
        return uRepo.save(user);
    }

    @Override
    public String homepage() {
        return "This is home page";
    }

    @Override
    public User getUser(Integer id) {
        return uRepo.findById(id);
    }

    @Override
    public User addUser(User user) {
        return uRepo.save(user);
    }


}
