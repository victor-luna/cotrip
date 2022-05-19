package com.api.cotrip.controllers;

import com.api.cotrip.dtos.UserDto;
import com.api.cotrip.models.UserModel;
import com.api.cotrip.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cotrip-user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCotripUser(@RequestBody @Valid UserDto userDto){

        if(userService.existsByCPF(userDto.getCPF())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel); // converte o DTO em Model.
        userModel.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

}
