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
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public User user;
    public boolean presenca;
    public boolean interesse;
    public boolean nao_foi;
    public String motivo;
    public boolean foi;
    public boolean gostou;
}
