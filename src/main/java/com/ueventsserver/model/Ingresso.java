package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ingresso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String descricao;
    public Double preco;
    public boolean esgotado;
    @ManyToOne
    @JoinColumn(name = "evento", referencedColumnName = "id", nullable = false)
    public Evento evento;
}
