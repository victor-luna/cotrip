package com.api.cotrip.controllers;

import com.api.cotrip.dtos.DestinoDto;
import com.api.cotrip.dtos.UserDto;
import com.api.cotrip.models.DestinoModel;
import com.api.cotrip.models.UserModel;
import com.api.cotrip.services.DestinoService;
import com.api.cotrip.services.UserService;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cotrip-usuario")

public class UserController {

    final UserService userService;

    final DestinoService destinoService;

    public UserController(UserService userService, DestinoService destinoService) {
        this.userService = userService;
        this.destinoService = destinoService;
    }



    @PostMapping
    public ResponseEntity<Object> saveCotripUser(@RequestBody @Valid UserDto userDto) {

        if (userService.existsByCPF(userDto.getCPF())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito: CPF em uso!");
        }

        var userModel = new UserModel();

        BeanUtils.copyProperties(userDto, userModel); // converte o DTO em Model.
        userModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));


        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping
    public ResponseEntity<Page<UserModel>> getAllCotripUsers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCotripUser(@PathVariable(value = "id") UUID id){
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCotripUser(@PathVariable(value = "id") UUID id){
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        userService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso.");
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> ser(@PathVariable(value = "id") UUID id,
//                                                    @RequestBody @Valid UserDto userDto){
//
//        Optional<UserModel> userModelOptional = userService.findById(id);
//        if (!userModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
//        }
//        var userModel = new UserModel();
//        BeanUtils.copyProperties(userDto, userModel);
//        userModel.setDataDeRegistro(userModelOptional.get().getDataDeRegistro());
//        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
//    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCotripUser(@PathVariable(value = "id") UUID id,
                                                           @RequestBody @Valid UserDto userDto, @RequestBody @Valid DestinoDto destinoDto){


        // UPDATE DO USUÁRIO
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);


        // UPDATE DO DESTINO
        Optional<DestinoModel> destinoModelOptional = destinoService.findById(id);
        if (!destinoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino não encontrado.");
        }
        var destinoModel = new DestinoModel();


        BeanUtils.copyProperties(destinoDto, destinoModel);
        BeanUtils.copyProperties(userDto, userModel);


        userModel.getDestinos().add(destinoModel);
        userModel.setDataDeRegistro(userModelOptional.get().getDataDeRegistro());
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveAndFlush(userModel));
    }



}
