package com.ueventsserver.service;

import com.ueventsserver.dto.UsuarioRegisterDTO;
import com.ueventsserver.model.Usuario;
import com.ueventsserver.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registerNewUser(UsuarioRegisterDTO registerDTO) {
        Usuario newUser = new Usuario();
        newUser.setNome(registerDTO.getNome());

        String hashedPassword = passwordEncoder.encode(registerDTO.getSenha());
        newUser.setSenha(hashedPassword);
        newUser.setDescriao("");
        newUser.setRefresh_token(null);
        newUser.setRefresh_validade(null);
        newUser.setContatos(null);
        newUser.setEventosOrganizados(null);
        newUser.setFoto_perfil(null);
        newUser.setSeguidores(null);
        newUser.setSeguindo(null);

        return usuarioRepository.save(newUser);
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }
}
