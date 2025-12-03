package com.ueventsserver.controller;

import com.ueventsserver.dto.UsuarioRegisterDTO;
import com.ueventsserver.model.Usuario;
import com.ueventsserver.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class UsuarioRegisterController {
    private final UsuarioService usuarioService;

    public UsuarioRegisterController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> register(@Valid @RequestBody UsuarioRegisterDTO registerDTO) {
        Usuario newUser = usuarioService.registerNewUser(registerDTO);
        return new ResponseEntity<>(newUser.id, HttpStatus.CREATED);
    }

    //metodo criado para testes, sera removido no futuro
    @GetMapping("/usuario")
    public ResponseEntity<Object> getUsuarioById(@RequestParam int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if(usuario != null) return new ResponseEntity<>(usuario, HttpStatus.OK);
        else {
            Map<String, String> errorMessage = Map.of("mensagem", "Usuário não encontrado com ID: " + id);
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }
}
