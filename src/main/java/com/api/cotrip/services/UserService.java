package com.api.cotrip.services;

import com.api.cotrip.models.UserModel;
import com.api.cotrip.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }

    public boolean existsByCPF(String CPF) {
        return userRepository.existsByCPF(CPF);
    }

}
