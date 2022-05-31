package com.api.cotrip.services;

import com.api.cotrip.models.DestinoModel;
import com.api.cotrip.repositories.DestinoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class DestinoService {

    final DestinoRepository destinoRepository;

    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    @Transactional
    public DestinoModel save(DestinoModel destinoModel) {
        return destinoRepository.save(destinoModel);
    }


    public Page<DestinoModel> findAll(Pageable pageable) {
        return destinoRepository.findAll(pageable);
    }

    public Optional<DestinoModel> findById(UUID id) {
        return destinoRepository.findById(id);
    }

    @Transactional
    public void delete(DestinoModel destinoModel) {
        destinoRepository.delete(destinoModel);
    }

}