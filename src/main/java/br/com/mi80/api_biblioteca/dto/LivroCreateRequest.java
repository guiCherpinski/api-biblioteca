package br.com.mi80.api_biblioteca.dto;

import br.com.mi80.api_biblioteca.entity.Genero;

import java.time.Year;

public record LivroCreateRequest(
        String descricao,
        String titulo,
        String autor,
        Year anoLancamento,
        Genero genero
) {

}
