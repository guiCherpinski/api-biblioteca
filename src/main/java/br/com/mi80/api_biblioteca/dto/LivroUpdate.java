package br.com.mi80.api_biblioteca.dto;

import br.com.mi80.api_biblioteca.entity.Genero;

public record LivroUpdate(
        String descricao,
        String titulo,
        String autor,
        Genero genero
) {

}
