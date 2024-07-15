package com.rajlee.creatingwhatsappapi.service;

import com.rajlee.creatingwhatsappapi.model.User;
import com.rajlee.creatingwhatsappapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Getting data from db"+users);
        return users;
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User removed"+id;
    }
}
