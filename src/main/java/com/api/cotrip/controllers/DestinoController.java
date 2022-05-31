package com.api.cotrip.controllers;


import com.api.cotrip.dtos.DestinoDto;
import com.api.cotrip.models.DestinoModel;
import com.api.cotrip.models.UserModel;
import com.api.cotrip.services.DestinoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cotrip-destino")

public class DestinoController extends UserModel{

    final DestinoService destinoService;

    public DestinoController(DestinoService destinoService) {
        this.destinoService = destinoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCotripDestino(@RequestBody @Valid DestinoDto destinoDto){

        var destinoModel = new DestinoModel();
        BeanUtils.copyProperties(destinoDto, destinoModel); // converte o DTO em Model.
        destinoModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));


        return ResponseEntity.status(HttpStatus.CREATED).body(destinoService.save(destinoModel));
    }

}
