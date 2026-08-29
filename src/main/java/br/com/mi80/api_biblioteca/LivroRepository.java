package br.com.mi80.api_biblioteca;

import br.com.mi80.api_biblioteca.entity.Genero;
import br.com.mi80.api_biblioteca.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByGenero (Genero genero);

    List<Livro> findByAutor (String autor);
}
