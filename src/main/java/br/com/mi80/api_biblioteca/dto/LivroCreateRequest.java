package br.com.mi80.api_biblioteca.dto;

import java.time.Year;

public record LivroCreateRequest (
        String descricao,
        String titulo,
        String autor,
        Year anoLancamento
) {

}
