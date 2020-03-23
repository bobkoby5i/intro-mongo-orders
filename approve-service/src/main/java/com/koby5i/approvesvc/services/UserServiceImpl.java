package com.koby5i.approvesvc.services;


import com.koby5i.approvesvc.domains.User;
import com.koby5i.approvesvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add); //fun with Java 8
        return users;
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getByUsername(String name) {
        return userRepository.findByUsername(name).orElse(null);
    }

    @Override
    public User saveOrUpdate(User user) {
        userRepository.save(user);
        //ObjectId.get()
        return user;
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

}
