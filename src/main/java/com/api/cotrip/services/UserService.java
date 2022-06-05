package com.api.cotrip.services;

import com.api.cotrip.models.UserModel;
import com.api.cotrip.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

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

    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public Optional<UserModel> findById(String id) {
        return userRepository.findById(id);
    }


    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }


    @Transactional
    public UserModel saveAndFlush(UserModel userModel) {
        return userRepository.saveAndFlush(userModel);
    }
}


