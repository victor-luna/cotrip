package com.api.cotrip.repositories;

import com.api.cotrip.models.DestinoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DestinoRepository extends JpaRepository<DestinoModel, UUID> {


}
