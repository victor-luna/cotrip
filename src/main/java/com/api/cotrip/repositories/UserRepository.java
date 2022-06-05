package com.api.cotrip.repositories;

import com.api.cotrip.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

    boolean existsByCPF(String CPF);
}
