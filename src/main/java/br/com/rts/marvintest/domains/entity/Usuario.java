package br.com.rts.marvintest.domains.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long identificador;

    private String nome;

    private String documento;

    private LocalDate dataCriacao;

    private LocalDate dataAtualizacao;
}
