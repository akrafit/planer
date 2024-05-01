package com.litium.planer.service;

import com.alibaba.fastjson.JSONObject;
import com.litium.planer.model.Role;
import com.litium.planer.model.Status;
import com.litium.planer.model.UserEntity;
import com.litium.planer.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Map<String, Object> addNewUser(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        String login = jsonObject.getString("login");
        String name = jsonObject.getString("name");
        String password = jsonObject.getString("password");

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(login);
        userEntity.setPasswordOpen(password);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
        userEntity.setPassword(bCryptPasswordEncoder.encode(password));
        userEntity.setStatus(Status.ACTIVE);
        userEntity.setRole(Role.USER);


        map.put("massage", "OK");
        userRepository.save(userEntity);
        return map;
    }

    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity getUserByName(String name) {
        return userRepository.findByEmail(name).get();
    }

    public Optional<UserEntity> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
