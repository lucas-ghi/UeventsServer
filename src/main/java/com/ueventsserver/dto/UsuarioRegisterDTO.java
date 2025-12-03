package com.ueventsserver.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRegisterDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "A senha é obrigatória")
    private String senha;
}
