package com.ueventsserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "atracao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String nome;
    public LocalTime horario;
    public String tipo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento", referencedColumnName = "id", unique = false, nullable = true)
    private Evento evento;
}
