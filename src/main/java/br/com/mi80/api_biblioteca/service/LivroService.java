package br.com.mi80.api_biblioteca.service;

import br.com.mi80.api_biblioteca.LivroRepository;
import br.com.mi80.api_biblioteca.dto.LivroCreateRequest;
import br.com.mi80.api_biblioteca.dto.LivroResponse;
import br.com.mi80.api_biblioteca.entity.Genero;
import br.com.mi80.api_biblioteca.entity.Livro;
import br.com.mi80.api_biblioteca.exception.LivroNaoEncontradoException;
import br.com.mi80.api_biblioteca.mapper.LivroMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;
    private final LivroMapper mapper;

    public LivroService(LivroRepository repository, LivroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ResponseEntity<List<LivroResponse>> listarLivros () {
        List<Livro> livros = repository.findAll();
        List<LivroResponse> response = mapper.toResponseList(livros);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<LivroResponse> buscarPorId(Long id) {
        Livro entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ERRO - ESSE ID NÃO EXISTE"));

        LivroResponse response = mapper.toResponse(entity);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<LivroResponse>> listarPorGenero(Genero genero) {
        List<Livro> entity = repository.findByGenero(genero);

        List<LivroResponse> response = mapper.toResponseList(entity);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<List<LivroResponse>> listarPorAutor(String autor) {
        List<Livro> entity = repository.findByAutor(autor);

        List<LivroResponse> response = mapper.toResponseList(entity);
        return ResponseEntity.ok(response);
    }

    public LivroResponse cadastrarLivro(LivroCreateRequest create) {
        Livro entity = mapper.toEntity(create);
        Livro entitySaved = repository.save(entity);

        return mapper.toResponse(entitySaved);
    }

    public void deletarLivro(Long id){
        Livro busca = repository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException("livro não encontrado"));
        repository.deleteById(id);
    }
}
