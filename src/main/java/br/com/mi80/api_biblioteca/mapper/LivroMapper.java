package br.com.mi80.api_biblioteca.mapper;

import br.com.mi80.api_biblioteca.dto.LivroCreateRequest;
import br.com.mi80.api_biblioteca.dto.LivroResponse;
import br.com.mi80.api_biblioteca.dto.LivroUpdate;
import br.com.mi80.api_biblioteca.entity.Livro;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class LivroMapper {

    public Livro toEntity(LivroCreateRequest request){
        return Livro.builder()
                .descricao(request.descricao())
                .titulo(request.titulo())
                .autor(request.autor())
                .anoLancamento(request.anoLancamento())
                .genero(request.genero())
                .build();
    }

    public LivroResponse toResponse(Livro livro) {
        return new LivroResponse(
                livro.getId(),
                livro.getDescricao(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getAnoLancamento(),
                livro.getGenero()
        );
    }

    public List<LivroResponse> toResponseList (List<Livro> livros) {
        return livros.stream().map(this :: toResponse).toList();
    }

    public void updateEntity(LivroUpdate update, Livro livro){
        livro.setDescricao(update.descricao());
        livro.setTitulo(update.titulo());
        livro.setAutor(update.autor());
        livro.setGenero(update.genero());
    }
}
