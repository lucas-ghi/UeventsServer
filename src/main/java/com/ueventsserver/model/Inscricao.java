package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inscricao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @ManyToOne
    @JoinColumn(name = "evento", referencedColumnName = "id", nullable = false)
    public Evento evento;
    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id", nullable = false)
    public Usuario usuario;
    public boolean presenca;
    public boolean interesse;
    public boolean nao_foi;
    public String motivo;
    public boolean foi;
    public boolean gostou;
}
