package com.marcelovalentino.falamundobackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioCadastroDTO {
    @NotEmpty(message = "A conta deve ser informada.")
    private String conta;

    @NotEmpty(message = "A senha deve ser informada.")
    private String senha;

    @NotEmpty(message = "O email deve ser informado.")
    @Email(message = "O email deve ser válido.")
    private String email;
}

