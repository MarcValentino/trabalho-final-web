package com.marcelovalentino.falamundobackend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionarCursoDTO {
    @NotEmpty(message = "O id do curso deve ser informado.")
    private Long idCurso;

}

