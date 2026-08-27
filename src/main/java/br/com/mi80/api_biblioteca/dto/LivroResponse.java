package br.com.mi80.api_biblioteca.dto;

import java.time.Year;

public record LivroResponse (
        Long id,
        String descricao,
        String titulo,
        String autor,
        Year anoLancamento
) {

}
