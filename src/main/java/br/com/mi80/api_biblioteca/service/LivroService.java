package br.com.mi80.api_biblioteca.service;

import br.com.mi80.api_biblioteca.LivroRepository;
import br.com.mi80.api_biblioteca.dto.LivroResponse;
import br.com.mi80.api_biblioteca.entity.Livro;
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
}
