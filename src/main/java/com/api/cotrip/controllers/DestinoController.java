package com.api.cotrip.controllers;


import com.api.cotrip.dtos.DestinoDto;
import com.api.cotrip.dtos.UserDto;
import com.api.cotrip.models.DestinoModel;

import com.api.cotrip.models.UserModel;
import com.api.cotrip.services.DestinoService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cotrip-destino")

public class DestinoController{

    final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCotripDestino(@RequestBody @Valid DestinoDto destinoDto){

        var destinoModel = new DestinoModel();
        BeanUtils.copyProperties(destinoDto, destinoModel); // converte o DTO em Model.

        return ResponseEntity.status(HttpStatus.CREATED).body(destinoService.save(destinoModel));
    }

    @GetMapping
    public ResponseEntity<Page<DestinoModel>> getAllCotripDestinos(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(destinoService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCotripDestino(@PathVariable(value = "id") UUID id){
        Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
        if (!destinoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinoModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCotripDestino(@PathVariable(value = "id") UUID id){
        Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
        if (!destinoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
        }
        destinoService.delete(destinoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Destino deletado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCotripDestino(@PathVariable(value = "id") UUID id,
                                                   @RequestBody @Valid DestinoDto destinoDto){
        Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
        if (!destinoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
        }
        var destinoModel = new DestinoModel();
        var userModel = new UserModel();
        userModel.getDestinos().stream().forEach(destino -> {
            destino.setUser(userModel);
        });


        BeanUtils.copyProperties(destinoDto, destinoModel);
        return ResponseEntity.status(HttpStatus.OK).body(destinoService.save(destinoModel));
    }


}
