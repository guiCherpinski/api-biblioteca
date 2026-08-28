package br.com.mi80.api_biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Entity
@Table(name = "livro")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String titulo;
    private String autor;
    private Year anoLancamento;

    @Enumerated(EnumType.STRING)
    private Genero genero;
}
