package br.com.mi80.api_biblioteca.controller;

import br.com.mi80.api_biblioteca.dto.LivroCreateRequest;
import br.com.mi80.api_biblioteca.dto.LivroResponse;
import br.com.mi80.api_biblioteca.entity.Genero;
import br.com.mi80.api_biblioteca.entity.Livro;
import br.com.mi80.api_biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/biblioteca")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<LivroResponse>> listarLivros() {
        return service.listarLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> buscarLivroPorId (@PathVariable @Valid Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/genero")
    public ResponseEntity<List<LivroResponse>> buscarLivroDescricao(@RequestParam Genero genero) {
        return service.listarPorGenero(genero);
    }

    @GetMapping("/autor")
    public ResponseEntity<List<LivroResponse>> buscarPorAutor(@RequestParam String autor) {
        return service.listarPorAutor(autor);
    }

    @PostMapping()
    public ResponseEntity<LivroResponse> cadastrarLivro(@RequestBody @Valid LivroCreateRequest create) {
        LivroResponse response = service.cadastrarLivro(create);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro (@PathVariable Long id){
        service.deletarLivro(id);
    }
}
