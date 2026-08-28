package br.com.mi80.api_biblioteca.controller;

import br.com.mi80.api_biblioteca.dto.LivroResponse;
import br.com.mi80.api_biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
