package com.cj.redislettucecache.service;

import com.cj.redislettucecache.entity.User;
import com.cj.redislettucecache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(cacheNames = "users", key = "#userId")
    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }
}
