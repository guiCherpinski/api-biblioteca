package br.com.mi80.api_biblioteca.dto;

import br.com.mi80.api_biblioteca.entity.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.Year;

public record LivroCreateRequest(
        @NotBlank(message = "A descricao nao pode ser vazia")
        @Size(min = 5, message = "A descricao nao pode ser tao curta")
        String descricao,

        @NotBlank(message = "O titulo nao pode ser vazio")
        @Size(min = 3, message = "O titulo nao pode ser tao curto")
        String titulo,

        @NotBlank(message = "O nome do autor nao pode ser vazio")
        @Size(min = 3, message = "O nome do autor nao pode ser tao curto")
        String autor,

        @NotNull(message = "Ano nao pode ser nulo")
        Year anoLancamento,

        @NotNull(message = "O genero do livro nao pode ser vazio")
        Genero genero
) {

}
